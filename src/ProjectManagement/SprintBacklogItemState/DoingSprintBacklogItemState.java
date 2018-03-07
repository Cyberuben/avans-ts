package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.Forum.Thread;
import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;
import ProjectManagement.SprintTask;
import Shared.MethodNotAllowedException;

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
        this.backlogItem.notifyStateChange("doing", "done");
    }

    public boolean isDone() {
        return false;
    }

    public Thread createThread(SprintMember member, String name, String message) {
        try {
            return this.backlogItem.sprint.project.forum.createThread(name, this.backlogItem, member.member, message);
        } catch (MethodNotAllowedException e) {
            System.out.println("Problem when creating thread");
            return null;
        }
    }
}
