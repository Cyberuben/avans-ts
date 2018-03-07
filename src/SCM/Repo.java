package SCM;

import ProjectManagement.Project;

import java.util.HashMap;

public class Repo {
    public Project project;
    public HashMap<String, Branch> branches = new HashMap<>();

    public Repo(Project project) {
        this.project = project;
    }

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
        Branch sourceBranch = this.branches.get(source);
        Branch targetBranch = this.branches.get(target);
        Commit latestSource = sourceBranch.commits.get(sourceBranch.commits.size() - 1);
        Commit latestTarget = targetBranch.commits.get(targetBranch.commits.size() - 1);

        if (latestSource.id > latestTarget.id) {
            targetBranch.commits.add(latestSource);
        }

        branches.remove(source);
        return branches.get(target);
    }
}
