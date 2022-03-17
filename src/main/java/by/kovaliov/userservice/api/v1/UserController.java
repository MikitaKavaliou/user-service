package by.kovaliov.userservice.api.v1;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import by.kovaliov.userservice.model.User;

public interface UserController {

  @PostMapping(path = "/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Void> createUser(@RequestBody User user);

  @GetMapping(path = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<User>> getUsers();

  @GetMapping(path = "/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<User> getUserById(@PathVariable Long id);

  @PutMapping(
      path = "/v1/users/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user);
}
