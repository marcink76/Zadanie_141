package pl.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.sender.EmailNotificationSender;
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
    public NotificationFacade facade(NotifyLogger logger, FileNotificationReader reader, EmailNotificationSender
            sender, SmsNotificationSender smsSender, ConsoleNotificationReader consReader) {
        NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger, smsSender, consReader);
        return notificationFacade;
    }

}
