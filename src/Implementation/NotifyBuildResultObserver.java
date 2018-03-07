package Implementation;

import Core.NotifyService.NotificationAgent;
import DevOps.BuildObserver;
import ProjectManagement.Member;
import ProjectManagement.Sprint;
import ProjectManagement.SprintMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NotifyBuildResultObserver implements BuildObserver {
    public void onSuccess(Sprint sprint) {
        // Send message to the product owner and scrummaster
        List<Member> sendTo = new ArrayList<>();
        for(Iterator<SprintMember> it = sprint.getMembersWithRole("scrummaster").iterator(); it.hasNext();) {
            SprintMember member = it.next();
            // Prevent someone from receiving the same message twice if they are both
            // scrum master and product owner
            if (!sendTo.contains(member.member)) {
                sendTo.add(member.member);
            }
        }

        for(Iterator<Member> it = sprint.project.getMembersWithRole("productowner").iterator(); it.hasNext();) {
            Member member = it.next();
            if (!sendTo.contains(member)) {
                sendTo.add(member);
            }
        }

        // Send the messages
        for(Iterator<Member> it = sendTo.iterator(); it.hasNext();) {
            Member member = it.next();
            NotificationAgent.getInstance().notify(member, "sprint-released", new HashMap<String, String>() {
                {
                    put("sprint", sprint.name);
                    put("project", sprint.project.name);
                }
            });
        }
    }

    public void onError(Exception e, Sprint sprint) {
        // Send message to the product owner and scrummaster
        for(Iterator<SprintMember> it = sprint.getMembersWithRole("scrummaster").iterator(); it.hasNext();) {
            SprintMember member = it.next();
            // Prevent someone from receiving the same message twice if they are both
            // scrum master and product owner
            NotificationAgent.getInstance().notify(member.member, "release-failed", new HashMap<String, String>() {
                {
                    put("error", e.toString());
                    put("sprint", sprint.name);
                    put("project", sprint.project.name);
                }
            });
        }
    }
}
