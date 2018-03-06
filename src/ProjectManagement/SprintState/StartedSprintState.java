package ProjectManagement.SprintState;

import ProjectManagement.Sprint;

import java.util.Date;

public class StartedSprintState extends SprintState {
    public StartedSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void finish() {
        if(this.sprint.endDate.before(new Date())) {
            this.sprint.state = new FinishedSprintState(this.sprint);
            return;
        }
    }
}
