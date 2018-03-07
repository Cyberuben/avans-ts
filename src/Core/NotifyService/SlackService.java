package Core.NotifyService;

import Core.MessageService.Message;
import ProjectManagement.Member;

public class SlackService extends NotifyService {

    Message message;

    public void onNotify(Member member, Message message) {
        // sendMessage(member, message);
    }
}
