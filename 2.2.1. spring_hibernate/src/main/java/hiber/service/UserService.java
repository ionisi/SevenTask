package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User getUserByCarModelAndSeries(String bmw, int i);

    void addUserWithCar(User user, String bmw, int i);
}
