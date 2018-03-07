package SCM;

public abstract class BranchObserver {
    public abstract void onCommit(Branch branch, Commit commit);
}
