package DevOps.BuildAgent;

public class BuildAgentControl {

    private Command InstallCommand, UndoCommand;

    public BuildAgentControl(Command Install, Command Undo) {
        InstallCommand = Install;
        UndoCommand = Undo;
    }

    public void packageReceived() {
        System.out.println("Ready to Install PackageAgent");

        InstallCommand.execute();
    }

    public void packageFailed() {
        System.out.println("Undoing Installing PackageAgent");

        UndoCommand.execute();
    }
}
