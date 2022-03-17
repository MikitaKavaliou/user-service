package by.kovaliov.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import by.kovaliov.userservice.model.User;
import by.kovaliov.userservice.repository.UserRepository;
import by.kovaliov.userservice.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> findUsers() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public User findUserById(Long id) {
    return userRepository
        .findById(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
  }

  @Override
  public User updateUserById(Long id, User user) {
    User existingUser = findUserById(id);
    user.setId(existingUser.getId());
    return userRepository.save(user);
  }
}
