package Implementation;

import Core.NotifyService.NotificationAgent;
import ProjectManagement.Forum.Post;
import ProjectManagement.Forum.Thread;
import ProjectManagement.Forum.ThreadObserver;
import ProjectManagement.SprintMember;

import java.util.HashMap;
import java.util.Iterator;

public class ThreadReplyObserver implements ThreadObserver {
    public void onPost(Thread thread, Post post) {
        for(Iterator<SprintMember> it = thread.item.sprint.members.iterator(); it.hasNext();) {
            SprintMember member = it.next();
            NotificationAgent.getInstance().notify(member.member, "thread-new-reply", new HashMap<String, String>() {
                {
                    put("thread", thread.name);
                    put("poster", post.member.name);
                    put("sprint", thread.item.sprint.name);
                    put("project", thread.item.sprint.project.name);
                }
            });
        }
    }
}
