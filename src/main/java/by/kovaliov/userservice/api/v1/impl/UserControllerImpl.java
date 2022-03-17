package by.kovaliov.userservice.api.v1.impl;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import by.kovaliov.userservice.api.v1.UserController;
import by.kovaliov.userservice.dto.UserDto;
import by.kovaliov.userservice.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<Void> createUser(UserDto userDto) {
    UserDto createdUser = userService.createUser(userDto);
    URI userUri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.getId())
            .toUri();

    return ResponseEntity.created(userUri).build();
  }

  @Override
  public ResponseEntity<List<UserDto>> getUsers() {
    return ResponseEntity.ok(userService.findUsers());
  }

  @Override
  public ResponseEntity<UserDto> getUserById(Long id) {
    return ResponseEntity.ok(userService.findUserById(id));
  }

  @Override
  public ResponseEntity<UserDto> updateUserById(Long id, UserDto userDto) {
    return ResponseEntity.ok(userService.updateUserById(id, userDto));
  }
}
