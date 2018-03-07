package DevOps.BuildAgent;

import DevOps.PackageAgent;

public class CustomBuild2 implements Command {

    private PackageAgent packageAgent;

    public CustomBuild2(PackageAgent P) {
        packageAgent = P;
    }

    @Override
    public void execute() {
        packageAgent.build();
    }
}
