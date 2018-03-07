package ProjectManagement.SprintState;

import DevOps.BuildObserver;
import ProjectManagement.Sprint;

public class ReleasingSprintState extends SprintState implements BuildObserver {
    public ReleasingSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void onSuccess(Sprint sprint) {
        this.sprint.state = new ClosedSprintState(this.sprint);
        this.sprint.notifyStateChange("releasing", "closed");
    }

    public void onError(Exception error, Sprint sprint) {
        this.sprint.state = new FinishedSprintState(this.sprint);
        this.sprint.notifyStateChange("releasing", "finished");
    }
}
