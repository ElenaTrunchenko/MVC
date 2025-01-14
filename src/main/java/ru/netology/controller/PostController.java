package ru.netology.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import java.util.Collection;

@Controller
@RequestMapping("/api/posts")
public class PostController {
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
  public Collection<Post> all() {
    return service.all();
  }

  @GetMapping("/{id}")
  public Post getById(@PathVariable long id) {
    return service.getById(id);
  }

  @PostMapping
  public Post save(@RequestBody Post post) {
    return service.save(post);
  }

  @DeleteMapping("/{id}")
  public void removeById(@PathVariable long id) {
    service.removeById(id);
  }
}