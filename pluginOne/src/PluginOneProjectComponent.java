import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;

public class PluginOneProjectComponent implements ProjectComponent {

    private static Context context;

    private Project project;

    public PluginOneProjectComponent(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        System.out.println("PluginOneProjectComponent started with project " + project.getName());
        context = Context.getInstance();

        DummyClass dummy = context.getComponent(DummyClass.class);
        System.out.println("DummyText from PluginOne " + dummy.getText());
        System.out.println("DummyNumber from PluginOne " + dummy.getNumber());
    }

    public static Context getContext() {
        return context;
    }
}
