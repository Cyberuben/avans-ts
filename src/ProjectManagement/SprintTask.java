package ProjectManagement;

public class SprintTask {
    public SprintBacklogItem backlogItem;
    public String name;
    public SprintMember assignedTo;
    public boolean done = false;

    public SprintTask(SprintBacklogItem item, String name) {
        this.backlogItem = item;
        this.name = name;
    }
}
