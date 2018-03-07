package DevOps;

import ProjectManagement.Sprint;

public interface BuildObserver {
    public void onSuccess(Sprint sprint);
    public void onError(Exception error, Sprint sprint);
}
