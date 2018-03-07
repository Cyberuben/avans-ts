package ProjectManagement.Forum;

import ProjectManagement.Member;

public class Post {
    public Member member;
    public Thread thread;
    public String message;

    public Post(Thread thread, Member member, String message) {
        this.member = member;
        this.thread = thread;
        this.message = message;
    }
}
