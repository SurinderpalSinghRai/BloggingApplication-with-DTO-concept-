package com.socialMedia.bloggingApplication.payloads;

import com.socialMedia.bloggingApplication.entities.Comments;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {


    @Id
    private String userId;

    @NotNull(message = "User name is mandatory")
    @Size(max = 20)
    private String userName;


    @NotNull(message = "User email is mandatory")
    private String userEmail;


    @NotNull(message = "User address mandatory")
    private String userAddress;

    List<Comments> comments;
}
