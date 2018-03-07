package ProjectManagement.SprintState;

import ProjectManagement.*;

import java.util.Date;

public class PreSprintState extends SprintState {
    public PreSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void setName(String name) {
        this.sprint.name = name;
    }

    public SprintBacklogItem addBacklogItem(BacklogItem item) {
        SprintBacklogItem i = new SprintBacklogItem(this.sprint, item);
        this.sprint.backlogItems.add(i);
        return i;
    }

    public SprintMember addMember(Member member) {
        SprintMember m = new SprintMember(member, this.sprint);
        this.sprint.members.add(m);
        return m;
    }

    public void setDuration(Date start, Date end) {
        this.sprint.startDate = start;
        this.sprint.endDate = end;
    }

    public void start() {
        this.sprint.state = new StartedSprintState(this.sprint);
        this.sprint.notifyStateChange("pre", "started");
    }

    public void setType(Sprint.SprintType type) {
        this.sprint.type = type;
    }
}
