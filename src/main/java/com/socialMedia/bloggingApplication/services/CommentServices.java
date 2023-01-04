package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;

import java.util.List;

public interface CommentServices {

    CommentDto addComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto, String commentId);

    CommentDto getCommentById(String commentId);

    List<CommentDto> getAllComments();

    void deleteComment(String commentId);
}
