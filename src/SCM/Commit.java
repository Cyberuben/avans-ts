package SCM;

import java.util.HashMap;

public class Commit {
    public static int _id = 1;
    public int id;
    public Branch branch;

    public Commit(Branch branch) {
        this.id = _id++;
        this.branch = branch;
    }
}
