package ProjectManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Member {
    public List<String> roles = new ArrayList<String>();
    public String name;
    public HashMap<String, String> notifyConfig = new HashMap<>();

    public Member(String name) {
        this.name = name;
    }
}
