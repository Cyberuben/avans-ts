package DevOps.BuildAgent;

public class BuildCommand implements Command {

    Build build;

    @Override
    public void execute() {
        build.build();
    }
}
