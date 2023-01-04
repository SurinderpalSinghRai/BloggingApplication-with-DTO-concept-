package com.socialMedia.bloggingApplication.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.List;
//import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "Users")
public class Users {
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
