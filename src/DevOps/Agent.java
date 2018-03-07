package DevOps;

import DevOps.BuildAgent.BuildAgent;
import ProjectManagement.Project;
import ProjectManagement.Sprint;

public class Agent {
    private static Agent instance;

    public static Agent getInstance() {
        if (instance == null) {
            instance = new Agent();
        }

        return instance;
    }

    public PackageAgent packageAgent;
    public BuildAgent buildAgent;
    public TestAgent testAgent;
    public DeployAgent deployAgent;

    public void build(BuildObserver ob, Sprint sprint) {
        try {
            packageAgent.build();

            buildAgent.build();

            testAgent.runTest();

            deployAgent.deploy();

            ob.onSuccess(sprint);
        } catch (Exception e) {
            ob.onError(e, sprint);
        }
    };
}
