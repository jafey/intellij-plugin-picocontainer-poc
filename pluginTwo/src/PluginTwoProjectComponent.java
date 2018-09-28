import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;

public class PluginTwoProjectComponent implements ProjectComponent {

    Project project;

    public PluginTwoProjectComponent(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        System.out.println("PluginTwoProjectComponent started with project " + project.getName());
        Context context = PluginOneProjectComponent.getContext();
        DummyClass dummy = context.getComponent(DummyClass.class);
        System.out.println("DummyText from Plugin Two" + dummy.getText());
        System.out.println("DummyNumber from Plugin Two" + dummy.getNumber());
    }
}
