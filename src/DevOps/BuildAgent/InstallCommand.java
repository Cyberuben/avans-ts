package DevOps.BuildAgent;

import DevOps.PackageAgent;

public class InstallCommand implements Command {

    private PackageAgent packageAgent;

    public InstallCommand(PackageAgent P) {
        packageAgent = P;
    }

    @Override
    public void execute() {
        packageAgent.build();
    }
}
