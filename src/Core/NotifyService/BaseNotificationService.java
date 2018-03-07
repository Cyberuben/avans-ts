package Core.NotifyService;

import Core.MessageService.BaseMessage;
import Core.INotificationSenderAdapter;

public abstract class BaseNotificationService {
    protected INotificationSenderAdapter sender;

    public void send(String to, BaseMessage message) {
        sender.sendMessage(to, message.getFinal());
    }
}
