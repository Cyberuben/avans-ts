package ProjectManagement.Forum;

import ProjectManagement.Member;
import ProjectManagement.Project;
import ProjectManagement.SprintBacklogItem;
import Shared.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    public Project project;
    public List<Thread> threads = new ArrayList<>();

    public Forum(Project project) {
        this.project = project;
    }

    public Thread createThread(String name, SprintBacklogItem item, Member member, String message) throws MethodNotAllowedException {
        if (item.isDone()) {
            throw new MethodNotAllowedException();
        }

        Thread thread = new Thread(this, name, item);
        thread.addPost(member, message);
        this.threads.add(thread);
        return thread;
    }
}
