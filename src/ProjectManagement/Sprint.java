package ProjectManagement;

import ProjectManagement.SprintState.SprintState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint {
    public Project project;
    public String name;
    public Date startDate;
    public Date endDate;
    public List<SprintMember> members = new ArrayList<SprintMember>();
    public SprintState state;
    public List<SprintBacklogItem> backlogItems = new ArrayList<>();

    public Sprint(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Date start, Date end) {
        this.startDate = start;
        this.endDate = end;
    }

    public SprintMember addMember(Member member) {
        SprintMember m = new SprintMember(member, this);
        this.members.add(m);
        return m;
    }
}
