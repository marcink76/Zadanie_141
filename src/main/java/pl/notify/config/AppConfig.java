package pl.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.ConsoleLogger;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.model.Notification;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.NotificationSender;
import pl.notify.sender.SmsNotificationSender;

//@Configuration
public class AppConfig {

    @Bean
    public NotifyLogger logger() {
        FileLogger fileLogger = new FileLogger();
        return fileLogger;
    }

    @Bean
    public FileNotificationReader reader() {
        FileNotificationReader fileNotificationReader = new FileNotificationReader();
        return fileNotificationReader;
    }

    @Bean
    public EmailNotificationSender sender() {
        EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
        return new EmailNotificationSender();
    }
    @Bean
    public SmsNotificationSender smsSender(){
        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
        return new SmsNotificationSender();
    }
    @Bean
    public ConsoleNotificationReader consReader(){
        ConsoleNotificationReader consoleNotificationReader = new ConsoleNotificationReader();
        return new ConsoleNotificationReader();
    }
    @Bean
    public ConsoleLogger consoleLogger(){
        ConsoleLogger consoleLogger = new ConsoleLogger();
        return new ConsoleLogger();
    }

    @Bean
    public NotificationFacade facade(NotificationReader reader, NotificationSender sender, NotifyLogger logger) {
        NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger);
        return notificationFacade;
    }
}