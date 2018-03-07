package Implementation;

import Core.INotificationSenderAdapter;

import java.util.ArrayList;
import java.util.List;

public class MemorySender implements INotificationSenderAdapter {
    public static List<SentMessage> sentMessages = new ArrayList<>();

    private class SentMessage {
        public String to;
        public String service;
        public String content;
    }

    public void init(/* fake config */) {
         /* do some fake setup */
    }

    public void sendMessage(String to, String content) {
        SentMessage message = new SentMessage();
        message.to = to;
        message.content = content;
        message.service = new Exception().getStackTrace()[1].getClassName();
        sentMessages.add(message);
    }
}
