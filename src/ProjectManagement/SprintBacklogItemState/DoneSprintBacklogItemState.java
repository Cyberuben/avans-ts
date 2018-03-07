package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintTask;

import java.util.Iterator;

public class DoneSprintBacklogItemState extends SprintBacklogItemState {
    public DoneSprintBacklogItemState(SprintBacklogItem item) {
        this.backlogItem = item;
    }

    public void setTodo() {
        this.backlogItem.state = new TodoSprintBacklogItemState(this.backlogItem);
        this.backlogItem.notifyStateChange("done", "todo");
    }

    public boolean isDone() {
        return true;
    }
}
