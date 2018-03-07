package Implementation;

import Core.NotifyService.BaseNotificationService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificationService extends BaseNotificationService {
    public List<Pair<String, String>> sentMessages = new ArrayList<>();

    public EmailNotificationService() {
        // Fake setting up a email sender
        this.sender = new MemorySenderI();
        this.sender.init(/* pass parameters */);
    }
}
