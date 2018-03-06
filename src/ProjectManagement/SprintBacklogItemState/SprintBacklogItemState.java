package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;

public class SprintBacklogItemState {
    public SprintBacklogItem backlogItem;

    public SprintBacklogItemState() {

    }

    public SprintBacklogItemState(SprintBacklogItem item) {
        this.backlogItem = item;
    }

    public void setDoing() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void setDone() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void setTodo() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void assignTo(SprintMember member) throws Exception {
        throw new Exception("Method not allowed");
    }

    public boolean isDone() throws Exception {
        throw new Exception("Method not allowed");
    }
}
