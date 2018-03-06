package ProjectManagement;

public class BacklogItem {
    public static int _id = 1;
    public int id;
    public String name;
    public Project project;

    public BacklogItem(String name, Project project) {
        this.id = _id++;
        this.name = name;
        this.project = project;
    }
}
