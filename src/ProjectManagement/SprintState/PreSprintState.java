package ProjectManagement.SprintState;

import ProjectManagement.BacklogItem;
import ProjectManagement.Sprint;

import java.util.Date;

public class PreSprintState extends SprintState {
    public PreSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void setName(String name) {
        this.sprint.name = name;
    }

    public void addBacklogItem(BacklogItem item) {
        // TODO: Add backlog items
    }

    public void setDuration(Date start, Date end) {
        this.sprint.startDate = start;
        this.sprint.endDate = end;
    }

    public void start() {
        this.sprint.state = new StartedSprintState(this.sprint);
    }
}
