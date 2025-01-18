package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void addUserWithCar(User user, String carModel, int carSeries);

   User getUserByCarModelAndSeries(String model, int series);
}
