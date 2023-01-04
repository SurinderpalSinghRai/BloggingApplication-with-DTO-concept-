package com.socialMedia.bloggingApplication.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Posts")
public class Posts {
    @Id
    private String postId;

    @NotNull(message = "Post title is mandatory")
    private String title;
    private String content;

    List<Comments> comments;

}
