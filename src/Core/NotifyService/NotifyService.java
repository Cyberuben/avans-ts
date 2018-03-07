package Core.NotifyService;

import Core.MessageService.IMessageService;
import Core.MessageService.Message;

public class NotifyService {

    public void onNotify(String to, IMessageService message) {

        message.createMessage();

    }
}
