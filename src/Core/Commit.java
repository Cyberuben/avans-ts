package Core;

import java.util.HashMap;

public class Commit {
    public static int _id = 1;
    public int id;
    public Branch branch;
    public HashMap<String, Integer> files;

    public Commit(HashMap<String, Integer> files, Branch branch) {
        this.id = _id++;
        this.branch = branch;
        this.files = files;
    }
}
