package ProjectManagement;

public interface SprintStateObserver {
    public void onStateChange(Sprint sprint, String prev, String current);
}
