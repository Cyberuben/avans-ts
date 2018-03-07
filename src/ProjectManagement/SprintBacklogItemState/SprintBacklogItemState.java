package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.Forum.Thread;
import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;
import ProjectManagement.SprintTask;
import Shared.MethodNotAllowedException;

public class SprintBacklogItemState {
    public SprintBacklogItem backlogItem;

    public SprintBacklogItemState() {

    }

    public void setDoing() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void setDone() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void setTodo() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void assignTo(SprintMember member) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public SprintTask addTask(String name) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public boolean isDone() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public Thread createThread(SprintMember member, String name, String message) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }
}
