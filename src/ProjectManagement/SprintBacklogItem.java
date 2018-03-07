package ProjectManagement;

import ProjectManagement.Forum.Thread;
import ProjectManagement.SprintBacklogItemState.SprintBacklogItemState;
import ProjectManagement.SprintBacklogItemState.SprintBacklogItemStateFactory;
import Shared.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SprintBacklogItem {
    public Sprint sprint;
    public BacklogItem backlogItem;
    public SprintBacklogItemState state;
    public SprintMember assignedTo;
    public List<SprintTask> tasks = new ArrayList<>();
    public List<BacklogItemStateObserver> observers = new ArrayList<>();

    public SprintBacklogItem(Sprint sprint, BacklogItem item) {
        this.sprint = sprint;
        this.backlogItem = item;
        this.state = SprintBacklogItemStateFactory.getTodoState(this);
    }

    public void setDoing() throws MethodNotAllowedException {
        this.state.setDoing();
    }

    public void setDone() throws MethodNotAllowedException {
        this.state.setDone();
    }

    public void setTodo() throws MethodNotAllowedException {
        this.state.setTodo();
    }

    public void assignTo(SprintMember member) throws MethodNotAllowedException {
        this.state.assignTo(member);
    }

    public SprintTask addTask(String name) throws MethodNotAllowedException {
        return this.state.addTask(name);
    }

    public boolean isDone() throws MethodNotAllowedException {
        return this.state.isDone();
    }

    public void subscribe(BacklogItemStateObserver ob) {
        if(!this.observers.contains(ob)) {
            this.observers.add(ob);
        }
    }

    public void unsubscribe(BacklogItemStateObserver ob) {
        if (this.observers.contains(ob)) {
            this.observers.remove(ob);
        }
    }

    public void notifyStateChange(String prev, String current) {
        for (Iterator<BacklogItemStateObserver> it = observers.iterator(); it.hasNext();) {
            BacklogItemStateObserver ob = it.next();
            if(ob != null) {
                ob.onStateChange(this, prev, current);
            }
        }
    }

    public Thread createThread(SprintMember member, String name, String message) throws MethodNotAllowedException {
        return this.state.createThread(member, name, message);
    }
}
