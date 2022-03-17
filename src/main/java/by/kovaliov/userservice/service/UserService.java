package by.kovaliov.userservice.service;

import java.util.List;

import by.kovaliov.userservice.dto.UserDto;

public interface UserService {

  UserDto createUser(UserDto user);

  List<UserDto> findUsers();

  UserDto findUserById(Long id);

  UserDto updateUserById(Long id, UserDto user);
}
