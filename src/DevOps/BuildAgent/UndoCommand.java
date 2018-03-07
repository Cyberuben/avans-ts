package DevOps.BuildAgent;

        import DevOps.PackageAgent;

public class UndoCommand implements Command {

    private PackageAgent packageAgent;

    public UndoCommand(PackageAgent P) {
        packageAgent = P;
    }

    @Override
    public void execute() {
//        packageAgent.undo();
    }
}
