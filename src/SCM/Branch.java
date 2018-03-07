package SCM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Branch {
    public Repo repo;
    public String name;
    public List<Commit> commits = new ArrayList<>();
    public List<BranchObserver> observers = new ArrayList<>();

    public Branch(String name, Repo repo) {
        this.repo = repo;
        this.name = name;
    }

    public Commit commit() {
        Commit c = new Commit(this);
        this.commits.add(c);
        for (Iterator<BranchObserver> it = observers.iterator(); it.hasNext();) {
            BranchObserver ob = it.next();
            if(ob != null) {
                ob.onCommit(this, c);
            }
        }
        return c;
    }

    public Commit pull() {
        return this.commits.get(this.commits.size() - 1);
    }

    public void subscribe(BranchObserver ob) {
        if(!this.observers.contains(ob)) {
            this.observers.add(ob);
        }
    }

    public void unsubscribe(BranchObserver ob) {
        if(this.observers.contains(ob)) {
            this.observers.remove(ob);
        }
    }
}
