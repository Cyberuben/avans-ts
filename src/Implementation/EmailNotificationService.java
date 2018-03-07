package Implementation;

import Core.INotificationSenderAdapter;
import Core.NotifyService.BaseNotificationService;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificationService extends BaseNotificationService {
    public List<Pair<String, String>> sentMessages = new ArrayList<>();

    public EmailNotificationService(INotificationSenderAdapter sender) {
        // Fake setting up a email sender
        this.sender = sender;
        this.sender.init(/* pass parameters */);
    }
}
