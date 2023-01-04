package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.repository.PostsRepository;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class PostServicesImpl  implements PostServices {
    @Autowired
    private PostsRepository postsRepository;
    @Override
    public PostDto addPost(PostDto postDto) {
        Posts post = this.dtoToPost(postDto);
        Posts savedPost = this.postsRepository.save(post);
        return this.postToDto(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, String postId) {
        Posts getPost = this.postsRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Posts","id",postId));
        getPost.setTitle(postDto.getTitle());
        getPost.setContent(postDto.getContent());
        getPost.setComments(postDto.getComments());
        Posts updatedPost = this.postsRepository.save(getPost);
        PostDto postDto1= this.postToDto(updatedPost);
        return postDto1;

    }

    @Override
    public PostDto getPostById(String postId) {
        Posts post = this.postsRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Posts","id",postId));

        return this.postToDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Posts> posts=this.postsRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post ->this.postToDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public void deletePost(String postId) {
        Posts post = this.postsRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Posts","id",postId));
        this.postsRepository.delete(post);
    }

    private Posts dtoToPost(PostDto postDto){
        Posts post = new Posts();
        post.setPostId(postDto.getPostId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setComments(postDto.getComments());
        return post;

    }
    private PostDto postToDto(Posts post){
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setComments(post.getComments());
        return postDto;

    }
}
