package Core.MessageService;

public class BacklogItemTodoMessage extends BaseMessage {
    public void init() {
        this.body = "The backlog item {{itemName}} has been moved to todo in sprint {{sprint}} in project {{project}}";
    }
}
