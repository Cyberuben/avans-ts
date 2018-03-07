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
        if (this.backlogItem.tasks.size() > 0) {
            for(Iterator<SprintTask> it = this.backlogItem.tasks.iterator(); it.hasNext();) {
                SprintTask task = it.next();
                if(!task.done) {
                    return false;
                }
            }
        }

        return true;
    }
}
