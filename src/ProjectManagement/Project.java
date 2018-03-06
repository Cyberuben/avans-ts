package ProjectManagement;

import ProjectManagement.SprintState.SprintState;

import java.util.ArrayList;
import java.util.List;

public class Project {
    public String name;
    public List<Member> members = new ArrayList<Member>();
    public List<BacklogItem> backlogItems = new ArrayList<BacklogItem>();
    public List<Sprint> sprints = new ArrayList<Sprint>();

    public Project(String name) {
        this.name = name;
    }

    public Member addMember(String name) {
        Member member = new Member(name);
        this.members.add(member);
        return member;
    }

    public BacklogItem addBacklogItem(String name) {
        BacklogItem item = new BacklogItem(name, this);
        this.backlogItems.add(item);
        return item;
    }

    public Sprint addSprint(String name) {
        Sprint sprint = new Sprint(name, this);
        this.sprints.add(sprint);
        return sprint;
    }
}
