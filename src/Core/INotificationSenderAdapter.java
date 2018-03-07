package Core;

public interface INotificationSenderAdapter {
    void init();
    void sendMessage(String to, String content);
}
