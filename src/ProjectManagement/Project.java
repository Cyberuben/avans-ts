package ProjectManagement;

import ProjectManagement.Forum.Forum;
import ProjectManagement.SprintState.SprintState;
import SCM.Repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Project {
    public String name;
    public List<Member> members = new ArrayList<Member>();
    public List<BacklogItem> backlogItems = new ArrayList<BacklogItem>();
    public List<Sprint> sprints = new ArrayList<Sprint>();
    public Forum forum;
    public Repo repo;

    public Project(String name) {
        this.name = name;
        this.forum = new Forum(this);
        this.repo = new Repo(this);
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

    public List<Member> getMembersWithRole(String role) {
        List<Member> members = new ArrayList<>();
        for(Iterator<Member> it = this.members.iterator(); it.hasNext();) {
            Member member = it.next();
            if (member.roles.contains(role)) {
                members.add(member);
            }
        }
        return members;
    }
}
