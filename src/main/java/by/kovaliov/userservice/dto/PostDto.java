package by.kovaliov.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

  private String userId;
  private Long id;
  private String title;
  private String body;
}
