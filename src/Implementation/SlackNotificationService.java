package Implementation;

import Core.INotificationSenderAdapter;
import Core.NotifyService.BaseNotificationService;

public class SlackNotificationService extends BaseNotificationService {
    public SlackNotificationService(INotificationSenderAdapter sender) {
        // Fake setting up a slack sender
        this.sender = sender;
        this.sender.init(/* pass parameters */);
    }
}
