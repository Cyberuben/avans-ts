package Core.MessageService;

import java.util.HashMap;

public class MessageFactory {

    HashMap<String, String> files;

    public String createMessage() {

        Message message = new Message();
        message.init();
        message.setData(files);
        message.getFinal();

        return message.toString();
    }
}