package by.kovaliov.userservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import by.kovaliov.userservice.dto.PostDto;
import by.kovaliov.userservice.dto.UserDto;
import by.kovaliov.userservice.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

  UserDto toDto(User user, List<PostDto> posts);

  UserDto toDto(User user);

  User toEntity(UserDto userDto);
}
