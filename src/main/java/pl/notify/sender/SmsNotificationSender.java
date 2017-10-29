package pl.notify.sender;

import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

@Component
public class SmsNotificationSender implements NotificationSender {
    public void send(Notification notification) {
        System.out.println("Sms wysłany o treści: " + notification.getContent() + "" + notification.getTelephone());
    }
}