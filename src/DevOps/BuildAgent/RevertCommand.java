package DevOps.BuildAgent;

public class RevertCommand implements Command {

    Build build;

    @Override
    public void execute() {
        build.revert();
    }
}