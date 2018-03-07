package DevOps;

import DevOps.BuildAgent.BuildAgent;
import ProjectManagement.Project;

public class Agent {

    public Project project;

    public PackageAgent packageAgent;
    public BuildAgent buildAgent;
    public TestAgent testAgent;
    public DeployAgent deployAgent;

    public void build() {

        packageAgent.install();

        buildAgent.build();

        testAgent.runTest();

        deployAgent.deploy();
    };
}
