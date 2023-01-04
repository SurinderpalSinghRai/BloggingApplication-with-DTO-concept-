package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Comments;
import com.socialMedia.bloggingApplication.payloads.CommentDto;
import com.socialMedia.bloggingApplication.payloads.PostDto;
import com.socialMedia.bloggingApplication.repository.CommentsRepository;
import com.socialMedia.bloggingApplication.services.CommentServices;
import com.socialMedia.bloggingApplication.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class CommentsController {

    @Autowired
    private CommentServices commentServices;

    @PostMapping("/addComment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        CommentDto commentDto1=this.commentServices.addComment(commentDto);
        return new ResponseEntity<>(commentDto1, HttpStatus.CREATED);

    }
    @PostMapping("/updateComment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable String commentId){
        CommentDto updatedComment = this.commentServices.updateComment(commentDto,commentId);
        return ResponseEntity.ok(updatedComment);

    }

    @DeleteMapping("/deleteComment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable String commentId){
        this.commentServices.deleteComment(commentId);
        return new ResponseEntity(Map.of("message","Comment deleted successfully"),HttpStatus.OK);

    }
    @GetMapping("/getAllComments")
    public ResponseEntity<List<CommentDto>> getAllComments(){
        return ResponseEntity.ok(this.commentServices.getAllComments());
    }
    @GetMapping("/getCommentById/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable String commentId){
        return ResponseEntity.ok(this.commentServices.getCommentById(commentId));
    }
}
