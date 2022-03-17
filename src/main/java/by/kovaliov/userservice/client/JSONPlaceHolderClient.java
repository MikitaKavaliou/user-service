package by.kovaliov.userservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import by.kovaliov.userservice.dto.PostDto;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JSONPlaceHolderClient {

  @GetMapping(value = "/posts")
  List<PostDto> getPosts();
}
