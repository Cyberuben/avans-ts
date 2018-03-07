package ProjectManagement.Forum;

import ProjectManagement.Member;
import ProjectManagement.SprintBacklogItem;
import Shared.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    public Forum forum;
    public String name;
    public SprintBacklogItem item;
    public List<Post> posts = new ArrayList<>();

    public Thread(Forum forum, String name, SprintBacklogItem item) {
        this.forum = forum;
        this.name = name;
        this.item = item;
    }

    public Post addPost(Member member, String message) throws MethodNotAllowedException {
        if (this.item.isDone()) {
            throw new MethodNotAllowedException();
        }

        Post post = new Post(this, member, message);
        this.posts.add(post);
        return post;
    }
}
