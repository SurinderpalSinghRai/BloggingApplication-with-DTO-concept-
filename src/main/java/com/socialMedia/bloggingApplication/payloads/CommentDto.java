package com.socialMedia.bloggingApplication.payloads;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommentDto {

    @Id
    private String comment_id;
    private String comment;
}
