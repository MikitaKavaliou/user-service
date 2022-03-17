package by.kovaliov.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import by.kovaliov.userservice.client.JSONPlaceHolderClient;
import by.kovaliov.userservice.dto.UserDto;
import by.kovaliov.userservice.mapper.UserMapper;
import by.kovaliov.userservice.model.User;
import by.kovaliov.userservice.repository.UserRepository;
import by.kovaliov.userservice.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final JSONPlaceHolderClient jsonPlaceHolderClient;

  @Override
  public UserDto createUser(UserDto user) {
    return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
  }

  @Override
  public List<UserDto> findUsers() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users.stream().map(userMapper::toDto).toList();
  }

  @Override
  public UserDto findUserById(Long id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
    return userMapper.toDto(user, jsonPlaceHolderClient.getPosts());
  }

  @Override
  public UserDto updateUserById(Long id, UserDto user) {
    User existingUser =
        userRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase()));
    user.setId(existingUser.getId());
    return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
  }
}
