package Implementation;

import Core.NotifyService.NotificationAgent;
import ProjectManagement.Member;
import ProjectManagement.Sprint;
import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;
import Shared.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CheckSprintFinishedObserver {
    public void onStateChange(Sprint sprint, String prev, String current) {
        try {
            if (!prev.equals("releasing") && current.equals("finished")) {
                boolean cancelRelease = false;
                for (Iterator<SprintBacklogItem> it = sprint.backlogItems.iterator(); it.hasNext();) {
                    SprintBacklogItem item = it.next();
                    if (!item.isDone()) {
                        cancelRelease = true;
                        break;
                    }
                }

                if(cancelRelease) {
                    // Cancel the release
                    sprint.cancelRelease();

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
                        NotificationAgent.getInstance().notify(member, "sprint-failed", new HashMap<String, String>() {
                            {
                                put("sprint", sprint.name);
                                put("project", sprint.project.name);
                            }
                        });
                    }
                    return;
                }

                // Start release or review
                switch(sprint.type) {
                    case PARTIAL_PRODUCT:
                        sprint.review();
                        break;
                    case RELEASE:
                        sprint.release();
                        break;
                    default:
                        System.out.println("Not implemented");
                }
            }
        } catch (MethodNotAllowedException e) {
            System.out.println(e);
        }
    }
}
