package Core.MessageService;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MessageFactory {

    static HashMap<String, Class<? extends BaseMessage>> templates = new HashMap<String, Class<? extends BaseMessage>>() {
        {
            put("backlog-item-todo", BacklogItemTodoMessage.class);
            put("sprint-failed", SprintFailedMessage.class);
            put("thread-new-reply", ThreadNewReplyMessage.class);
        }
    };

    public static BaseMessage createMessage(String name) {
        if (!templates.containsKey(name)) {
            System.out.println("Message type "+name+" doesn't exist");
            return null;
        }

        Class<? extends BaseMessage> messageClass = templates.get(name);
        try {
            return messageClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.print(e);
            return null;
        }
    }
}