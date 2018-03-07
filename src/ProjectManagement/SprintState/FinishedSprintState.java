package ProjectManagement.SprintState;

import DevOps.Agent;
import ProjectManagement.Sprint;

public class FinishedSprintState extends SprintState {
    public FinishedSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void release() {
        if (this.sprint.type != Sprint.SprintType.RELEASE) {
            System.out.println("This sprint isn't of type release");
            return;
        }

        ReleasingSprintState newState = new ReleasingSprintState(this.sprint);
        this.sprint.state = newState;
        Agent.getInstance().build(newState);
        this.sprint.notifyStateChange("finished", "releasing");
    }

    public void review() {
        if (this.sprint.type != Sprint.SprintType.PARTIAL_PRODUCT) {
            System.out.println("This sprint isn't of type partial product");
            return;
        }

        this.sprint.state = new ReviewingSprintState(this.sprint);
        this.sprint.notifyStateChange("finished", "reviewing");
    }

    public void cancelRelease() {
        this.sprint.state = new ClosedSprintState(this.sprint);
        this.sprint.notifyStateChange("finished", "closed");
    }
}
