package Core.MessageService;

public class ThreadNewReplyMessage extends BaseMessage {
    public void init() {
        this.body = "A new post was placed by {{poster}} in thread {{thread}} (sprint {{sprint}} of {{project}})";
    }
}