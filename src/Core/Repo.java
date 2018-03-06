package Core;

import ProjectManagement.Project;

import java.util.HashMap;

public class Repo {
    public Project project;
    public HashMap<String, Branch> branches = new HashMap<>();

    public Branch branch(String name) {
        if(branches.containsKey(name)) {
            return branches.get(name);
        }

        Branch branch = new Branch(name, this);
        branches.put(name, branch);
        return branch;
    }

    public Branch checkout(String name) {
        return branches.get(name);
    }

    public Branch merge(String source, String target) {
        // TODO: Merge logic

        branches.remove(source);
        return branches.get(target);
    }
}
