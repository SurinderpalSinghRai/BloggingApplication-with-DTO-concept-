package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.PostServices;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostServices postServices;

    @PostMapping("/addPost")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto){
        PostDto postDto1=this.postServices.addPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);

    }
    @PostMapping("/updatePost/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable String postId){
        PostDto updatedPost=this.postServices.updatePost(postDto,postId);
        return ResponseEntity.ok(updatedPost);

    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable String postId){
        this.postServices.deletePost(postId);
        return new ResponseEntity(Map.of("message","post deleted successfully"),HttpStatus.OK);

    }
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(this.postServices.getAllPosts());
    }
    @GetMapping("/getPostById/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable String postId){
        return ResponseEntity.ok(this.postServices.getPostById(postId));
    }
}
