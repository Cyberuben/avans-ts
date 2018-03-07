package Core.MessageService;

public class ReleaseFailedMessage extends BaseMessage {
    public void init() {
        this.body = "The release of sprint {{sprint}} in project {{project}} ran into an error: {{error}}";
    }
}