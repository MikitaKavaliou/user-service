package by.kovaliov.userservice.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

  private Long id;
  private String username;
  private String password;
  private String phoneNumber;
  private List<PostDto> posts;
}
