package Core.NotifyService;

import Core.MessageService.BaseMessage;
import Core.MessageService.MessageFactory;
import ProjectManagement.Member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NotificationAgent {
    private static NotificationAgent instance;

    private HashMap<String, BaseNotificationService> services = new HashMap<>();

    public static NotificationAgent getInstance() {
        if (instance == null) {
            instance = new NotificationAgent();
        }

        return instance;
    }

    public void registerService(String name, BaseNotificationService service) {
        this.services.put(name, service);
    }

    public void notify(Member member, String template, HashMap<String, String> data) {
        BaseMessage message = MessageFactory.createMessage(template);
        message.init();
        message.setData(data);

        for(Iterator<Map.Entry<String, BaseNotificationService>> it = services.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, BaseNotificationService> entry = it.next();
            if (member.notifyConfig.containsKey(entry.getKey())) {
                entry.getValue().send(member.notifyConfig.get(entry.getKey()), message);
            }
        }
    }
}
