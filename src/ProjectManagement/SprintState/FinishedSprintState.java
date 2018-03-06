package ProjectManagement.SprintState;

import ProjectManagement.Sprint;

public class FinishedSprintState extends SprintState {
    public FinishedSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void release() {
        this.sprint.state = new ReleasingSprintState(this.sprint);
    }

    public void review() {
        this.sprint.state = new ReviewingSprintState(this.sprint);
    }

    public void cancelRelease() {
        this.sprint.state = new ClosedSprintState(this.sprint);
    }
}
