package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintTask;

import java.util.Iterator;

public class DoingSprintBacklogItemState extends SprintBacklogItemState {
    public DoingSprintBacklogItemState(SprintBacklogItem item) {
        this.backlogItem = item;
    }

    public void setDone() {
        if(this.backlogItem.tasks.size() > 0) {
            for(Iterator<SprintTask> it = this.backlogItem.tasks.iterator(); it.hasNext();) {
                SprintTask task = it.next();
                if(task != null) {
                    if(!task.done) {
                        // TODO: Print error message
                        return;
                    }
                }
            }
        }

        this.backlogItem.state = new DoneSprintBacklogItemState(this.backlogItem);
    }

    public boolean isDone() {
        return false;
    }
}
