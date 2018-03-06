package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public class SprintMember {
    public Sprint sprint;
    public Member member;
    public List<String> roles = new ArrayList<String>();

    public SprintMember(Member member, Sprint sprint) {
        this.sprint = sprint;
        this.member = member;
    }
}
