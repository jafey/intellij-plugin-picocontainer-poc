import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class Context {

    private static Context instance;

    private final MutablePicoContainer picoContainer;

    public static synchronized Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public Context() {
        picoContainer = new DefaultPicoContainer();
        picoContainer.addComponent(DummyClass.class);
    }

    public <T> T getComponent(Class<T> clazz) {
        return picoContainer.getComponent(clazz);
    }

    public MutablePicoContainer getPicoContainer() {
        return picoContainer;
    }
}

