package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 1)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Lada", 3)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Mercedes", 5)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Audi", 7)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("Name = "+user.getFirstName());
         System.out.println("Car = " + user.getCar().getModel());
         System.out.println();
      }

      User user = userService.getUserByCar("Mercedes", 9);
      System.out.println("Find user " + user);

      user = userService.getUserByCar("Mercedes", 5);
      System.out.println("Find user " + user);

      //new Scanner(System.in).nextLine();

      context.close();
   }
}
