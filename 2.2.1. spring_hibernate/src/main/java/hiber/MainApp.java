package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUserWithCar(new User("User1", "Lastname1", "user1@mail.ru"), "BMW", 2020);
      userService.addUserWithCar(new User("User2", "Lastname2", "user2@mail.ru"), "Audi", 2021);
      userService.addUserWithCar(new User("User3", "Lastname3", "user3@mail.ru"), "Toyota", 2022);
      userService.addUserWithCar(new User("User4", "Lastname4", "user4@mail.ru"), "Mercedes", 2023);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car Model = " + (user.getCar() != null ? user.getCar().getModel() : "No Car"));
         System.out.println();
      }

      User foundUser = userService.getUserByCarModelAndSeries("BMW", 2020);
      if (foundUser != null) {
         System.out.println("Found User: " + foundUser.getFirstName() + " with Car: " + foundUser.getCar().getModel());
      } else {
         System.out.println("No user found with that car.");
      }

      context.close();
   }
}
