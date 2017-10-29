package pl.notify.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.notify.logger.FileLogger;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.SmsNotificationSender;

import java.io.IOException;

/**
 * Konfiguracja beanów springa w pliku beans-config.xml
 */
public class NotificationApplication {
    public static void main(String[] args) {

        FileNotificationReader reader = new FileNotificationReader();
        EmailNotificationSender sender = new EmailNotificationSender();
        SmsNotificationSender smsSender = new SmsNotificationSender();
        ConsoleNotificationReader consReader = new ConsoleNotificationReader();


        FileLogger logger = new FileLogger();
        NotificationFacade facade = new NotificationFacade(reader, sender, logger, smsSender, consReader);
        try {
            facade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
