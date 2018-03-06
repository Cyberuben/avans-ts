package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;

public class TodoSprintBacklogItemState extends SprintBacklogItemState {
    public TodoSprintBacklogItemState(SprintBacklogItem item) {
        this.backlogItem = item;
    }

    public void setDoing() {
        if(this.backlogItem.assignedTo == null && this.backlogItem.tasks.size() == 0) {
            // TODO: Show error message, can't start without tasks or assigning
            return;
        }

        this.backlogItem.state = new DoingSprintBacklogItemState(this.backlogItem);
    }

    public void assignTo(SprintMember member) {
        if(this.backlogItem.tasks.size() > 0) {
            // TODO: Show error message, already has tasks
            return;
        }

        this.backlogItem.assignedTo = member;
    }

    public boolean isDone() {
        return false;
    }
}
