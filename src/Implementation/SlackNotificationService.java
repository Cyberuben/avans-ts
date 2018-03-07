package Implementation;

import Core.NotifyService.BaseNotificationService;

public class SlackNotificationService extends BaseNotificationService {
    public SlackNotificationService() {
        // Fake setting up a slack sender
        this.sender = new MemorySenderI();
        this.sender.init(/* pass parameters */);
    }
}
