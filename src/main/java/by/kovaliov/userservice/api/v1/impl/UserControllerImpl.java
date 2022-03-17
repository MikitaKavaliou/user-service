package by.kovaliov.userservice.api.v1.impl;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import by.kovaliov.userservice.api.v1.UserController;
import by.kovaliov.userservice.model.User;
import by.kovaliov.userservice.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<Void> createUser(User user) {
    User createdUser = userService.createUser(user);
    URI userUri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.getId())
            .toUri();

    return ResponseEntity.created(userUri).build();
  }

  @Override
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.findUsers());
  }

  @Override
  public ResponseEntity<User> getUserById(Long id) {
    return ResponseEntity.ok(userService.findUserById(id));
  }

  @Override
  public ResponseEntity<User> updateUserById(Long id, User user) {
    return ResponseEntity.ok(userService.updateUserById(id, user));
  }
}
