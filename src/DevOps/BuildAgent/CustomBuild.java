package DevOps.BuildAgent;

import DevOps.PackageAgent;

public class CustomBuild implements Command {

    private PackageAgent packageAgent;

    public CustomBuild(PackageAgent P) {
        packageAgent = P;
    }

    @Override
    public void execute() {
        packageAgent.build();
    }
}
