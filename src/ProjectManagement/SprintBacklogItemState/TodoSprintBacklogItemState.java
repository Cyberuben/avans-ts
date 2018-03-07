package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.Forum.Thread;
import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;
import ProjectManagement.SprintTask;
import Shared.MethodNotAllowedException;

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
        this.backlogItem.notifyStateChange("todo", "doing");
    }

    public void assignTo(SprintMember member) {
        if(this.backlogItem.tasks.size() > 0) {
            // TODO: Show error message, already has tasks
            return;
        }

        this.backlogItem.assignedTo = member;
    }

    public SprintTask addTask(String name) {
        if(this.backlogItem.assignedTo != null) {
            // TODO: Show error message, already assigned
            return null;
        }

        SprintTask task = new SprintTask(this.backlogItem, name);
        this.backlogItem.tasks.add(task);
        return task;
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
