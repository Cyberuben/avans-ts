package Implementation;

import Core.NotifyService.NotificationAgent;
import ProjectManagement.BacklogItemStateObserver;
import ProjectManagement.SprintBacklogItem;
import ProjectManagement.SprintMember;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NotifyBacklogItemTodoObserver extends BacklogItemStateObserver {
    public void onStateChange(SprintBacklogItem item, String prev, String current) {
        if (prev.equals("done") && current.equals("todo")) {
            for(Iterator<SprintMember> it = item.sprint.getMembersWithRole("scrummaster").iterator(); it.hasNext();) {
                SprintMember member = it.next();
                NotificationAgent.getInstance().notify(member.member, "backlog-item-todo", new HashMap<String, String>() {
                    {
                        put("itemName", item.backlogItem.name);
                        put("sprint", item.sprint.name);
                        put("project", item.sprint.project.name);
                    }
                });
            }
        }
    }
}
