package pl.notify.app;

import org.springframework.stereotype.Component;
import pl.notify.logger.NotifyLogger;
import pl.notify.model.Notification;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.SmsNotificationSender;

import java.io.IOException;
import java.util.List;

@Component
public class NotificationFacade {
    private FileNotificationReader reader;
    private EmailNotificationSender sender;
    private NotifyLogger logger;
    private SmsNotificationSender smsSender;
    private ConsoleNotificationReader consReader;

    public NotificationFacade(FileNotificationReader reader, EmailNotificationSender sender, NotifyLogger logger, SmsNotificationSender smsSender, ConsoleNotificationReader consReader) {
        this.reader = reader;
        this.sender = sender;
        this.logger = logger;
        this.smsSender = smsSender;
        this.consReader = consReader;
    }

    public void sendNotifications() throws IOException {
        List<Notification> notifications = consReader.getNotifications();
        for (Notification notification : notifications) {
            smsSender.send(notification);
            logger.log(notification.toString());
        }
    }
}
