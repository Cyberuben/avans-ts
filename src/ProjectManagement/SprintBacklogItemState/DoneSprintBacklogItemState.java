package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;

public class DoneSprintBacklogItemState extends SprintBacklogItemState {
    public DoneSprintBacklogItemState(SprintBacklogItem item) {
        this.backlogItem = item;
    }

    public void setTodo() {
        this.backlogItem.state = new TodoSprintBacklogItemState(this.backlogItem);
    }

    public boolean isDone() {
        return true;
    }
}
