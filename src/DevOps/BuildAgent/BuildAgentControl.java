package DevOps.BuildAgent;

public class BuildAgentControl {

    private Command BuildCommand, RevertCommand;

    public BuildAgentControl(Command Build, Command Revert) {
        BuildCommand = Build;
        RevertCommand = Revert;
    }

    public void buildStart() {
        System.out.println("Start Building");

        BuildCommand.execute();
    }

    public void buildDone() {
        System.out.println("Build Done");
    }

    public void buildFailed() {
        System.out.println("Revert Build");

        RevertCommand.execute();
    }
}
