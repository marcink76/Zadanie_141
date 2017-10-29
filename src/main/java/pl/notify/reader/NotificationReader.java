package pl.notify.reader;

import pl.notify.model.Notification;

import java.util.List;

public interface NotificationReader {
    List<Notification> getNotifications();
}
