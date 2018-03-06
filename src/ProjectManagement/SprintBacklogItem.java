package ProjectManagement;

import ProjectManagement.SprintBacklogItemState.SprintBacklogItemState;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklogItem {
    public Sprint sprint;
    public BacklogItem backlogItem;
    public SprintBacklogItemState state;
    public SprintMember assignedTo;
    public List<SprintTask> tasks = new ArrayList<>();

    public void setDoing() throws Exception {
        this.state.setDoing();
    }

    public void setDone() throws Exception {
        this.state.setDone();
    }

    public void setTodo() throws Exception {
        this.state.setTodo();
    }

    public void assignTo(SprintMember member) throws Exception {
        this.state.assignTo(member);
    }

    public boolean isDone() throws Exception {
        return this.state.isDone();
    }
}
