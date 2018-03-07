package Core.MessageService;

public class SprintReleasedMessage extends BaseMessage {
    public void init() {
        this.body = "The sprint {{sprint}} in project {{project}} has been released successfully";
    }
}