package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.payloads.UserDto;

import java.util.List;

public interface UserServices {
    UserDto addUser(UserDto user);

    UserDto updateUser(UserDto user, String userId);

    UserDto getUserById(String userId);

    List<UserDto> getAllUsers();

    void deleteUser(String userId);
}
