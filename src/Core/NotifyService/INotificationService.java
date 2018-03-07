package Core.NotifyService;

import Core.MessageService.BaseMessage;

public interface INotificationService {
    public void send(String to, BaseMessage message);
}
