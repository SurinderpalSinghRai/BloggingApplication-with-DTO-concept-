package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.entities.Posts;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import com.socialMedia.bloggingApplication.repository.PostsRepository;
import com.socialMedia.bloggingApplication.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentServicesImpl implements CommentServices {

    @Autowired
    private CommentsRepository commentsRepository;


    private Comments dtoToComment(CommentDto commentDto){
        Comments comment = new Comments();
        comment.setComment_id(commentDto.getComment_id());
        comment.setComment(commentDto.getComment());
        return comment;

    }
    private CommentDto commentToDto(Comments comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setComment_id(comment.getComment_id());
        commentDto.setComment(comment.getComment());
        return commentDto;

    }

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        Comments comment = this.dtoToComment(commentDto);
        Comments savedComment = this.commentsRepository.save(comment);
        return this.commentToDto(savedComment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, String commentId) {
        Comments getComment = this.commentsRepository.findById(commentId)
                .orElseThrow(()->new ResourceNotFoundException("Comments","id",commentId));
        getComment.setComment(commentDto.getComment());
        Comments updatedComment = this.commentsRepository.save(getComment);
        CommentDto commentDto1= this.commentToDto(updatedComment);
        return commentDto1;
    }

    @Override
    public CommentDto getCommentById(String commentId) {
        Comments comment = this.commentsRepository.findById(commentId)
                .orElseThrow(()->new ResourceNotFoundException("Comments","id",commentId));

        return this.commentToDto(comment);

    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comments> comments=this.commentsRepository.findAll();
        List<CommentDto> commentDtos = comments.stream().map(comment ->this.commentToDto(comment)).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public void deleteComment(String commentId) {
        Comments comment = this.commentsRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comments","id",commentId));
        this.commentsRepository.delete(comment);

    }
}
