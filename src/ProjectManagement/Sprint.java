package ProjectManagement;

import ProjectManagement.SprintState.SprintState;
import ProjectManagement.SprintState.SprintStateFactory;
import Shared.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sprint {
    public Project project;
    public String name;
    public Date startDate;
    public Date endDate;
    public List<SprintMember> members = new ArrayList<SprintMember>();
    public SprintState state;
    public List<SprintBacklogItem> backlogItems = new ArrayList<>();
    public SprintType type;
    public List<SprintStateObserver> observers = new ArrayList<>();

    public enum SprintType {
        PARTIAL_PRODUCT,
        RELEASE
    }

    public Sprint(String name, Project project) {
        this.name = name;
        this.project = project;
        this.state = SprintStateFactory.getPreSprintState(this);
    }

    public void setName(String name) throws MethodNotAllowedException {
        this.state.setName(name);
    }

    public void setDuration(Date start, Date end) throws MethodNotAllowedException {
        this.state.setDuration(start, end);
    }

    public SprintMember addMember(Member member) throws MethodNotAllowedException {
        return this.state.addMember(member);
    }

    public SprintBacklogItem addBacklogItem(BacklogItem item) throws MethodNotAllowedException {
        return this.state.addBacklogItem(item);
    }

    public void setType(SprintType type) throws MethodNotAllowedException {
        this.state.setType(type);
    }

    public void start() throws MethodNotAllowedException {
        this.state.start();
    }

    public void finish() throws MethodNotAllowedException {
        this.state.finish();
    }

    public void release() throws MethodNotAllowedException {
        this.state.release();
    }

    public void review() throws MethodNotAllowedException {
        this.state.review();
    }

    public void cancelRelease() throws MethodNotAllowedException {
        this.state.cancelRelease();
    }

    public void finishReview(String file) throws MethodNotAllowedException {
        this.state.finishReview(file);
    }

    public void subscribe(SprintStateObserver ob) {
        if(!this.observers.contains(ob)) {
            this.observers.add(ob);
        }
    }

    public void unsubscribe(SprintStateObserver ob) {
        if (this.observers.contains(ob)) {
            this.observers.remove(ob);
        }
    }

    public void notifyStateChange(String prev, String current) {
        for (Iterator<SprintStateObserver> it = observers.iterator(); it.hasNext();) {
            SprintStateObserver ob = it.next();
            if(ob != null) {
                ob.onStateChange(this, prev, current);
            }
        }
    }

    public List<SprintMember> getMembersWithRole(String role) {
        List<SprintMember> members = new ArrayList<>();
        for(Iterator<SprintMember> it = this.members.iterator(); it.hasNext();) {
            SprintMember member = it.next();
            if (member.roles.contains(role)) {
                members.add(member);
            }
        }
        return members;
    }
}
