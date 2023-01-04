package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;

import java.util.List;

public interface PostServices {
    PostDto addPost(PostDto postDto);

    PostDto updatePost(PostDto postDto, String postId);

    PostDto getPostById(String postId);

    List<PostDto> getAllPosts();

    void deletePost(String postId);
}
