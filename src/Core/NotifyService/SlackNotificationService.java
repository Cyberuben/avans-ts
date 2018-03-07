package Core.NotifyService;

import Core.MessageService.BaseMessage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SlackNotificationService implements INotificationService {
    public List<Pair<String, String>> sentMessages = new ArrayList<>();

    public void send(String to, BaseMessage message) {
        // Faking sending slack message
        sentMessages.add(new Pair(to, message.getFinal()));
    }
}
