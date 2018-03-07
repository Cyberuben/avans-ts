package ProjectManagement;

public abstract class BacklogItemStateObserver {
    public abstract void onStateChange(SprintBacklogItem item, String previous, String current);
}
