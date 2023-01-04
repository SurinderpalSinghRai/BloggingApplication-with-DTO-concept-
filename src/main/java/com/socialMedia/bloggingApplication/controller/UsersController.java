package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UsersController {


    @Autowired
    private UserServices userServices;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto userDto1=this.userServices.addUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);

    }
    @PostMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable String userId){
        UserDto updatedUser=this.userServices.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        this.userServices.deleteUser(userId);
        return new ResponseEntity(Map.of("message","user deleted successfully"),HttpStatus.OK);

    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userServices.getAllUsers());
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId){
        return ResponseEntity.ok(this.userServices.getUserById(userId));
    }

}
