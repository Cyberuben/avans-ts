package Core.MessageService;

public class SprintFailedMessage extends BaseMessage {
    public void init() {
        this.body = "Sprint {{sprint}} release failed in project {{project}}";
    }
}
