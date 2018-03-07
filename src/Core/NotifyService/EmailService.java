package Core.NotifyService;

import Core.MessageService.Message;
import ProjectManagement.Member;

public class EmailService extends NotifyService {

    Message message;

    public void onNotify(Member member, Message message) {
        // sendMail(member, message);
    }
}
