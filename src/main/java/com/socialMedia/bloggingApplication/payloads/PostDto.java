package com.socialMedia.bloggingApplication.payloads;

import com.socialMedia.bloggingApplication.entities.Comments;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostDto {


    @Id
    private String postId;


    @NotNull(message = "Post title is mandatory")
    private String title;
    private String content;

    List<Comments> comments;
}
