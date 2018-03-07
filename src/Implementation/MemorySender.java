package Implementation;

import Core.INotificationSenderAdapter;

import java.util.ArrayList;
import java.util.List;

public class MemorySender implements INotificationSenderAdapter {
    public List<SentMessage> sentMessages;

    private class SentMessage {
        public String to;
        public String service;
        public String content;
    }

    public void init(/* fake config */) {
         this.sentMessages = new ArrayList<>();
    }

    public void sendMessage(String to, String content) {
        SentMessage message = new SentMessage();
        message.to = to;
        message.content = content;
        message.service = new Exception().getStackTrace()[1].getClassName();
        this.sentMessages.add(message);
    }
}
