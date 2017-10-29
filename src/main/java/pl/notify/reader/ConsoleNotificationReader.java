package pl.notify.reader;

import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class ConsoleNotificationReader implements NotificationReader{
    @Override
    public List<Notification> getNotifications() {

        List<Notification> notificationList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Podaj imie: ");
            String username =  scanner.nextLine();

            System.out.println("Podaj email: ");
            String email = scanner.nextLine();

            System.out.println("podaj nr telefonu: ");
            String telephone = scanner.nextLine();

            System.out.println("Podaj wiadomość: ");
            String content = scanner.nextLine();

            notificationList.add(new Notification(username, email, telephone, content));

            System.out.println("Jesli nie chcesz juz wprowadzac danych wpisz STOP!");
        }while (!scanner.nextLine().equals("STOP"));

        return notificationList;
    }
}
