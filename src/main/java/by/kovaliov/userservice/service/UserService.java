package by.kovaliov.userservice.service;

import java.util.List;

import by.kovaliov.userservice.model.User;

public interface UserService {

  User createUser(User user);

  List<User> findUsers();

  User findUserById(Long id);

  User updateUserById(Long id, User user);
}
