package com.socialMedia.bloggingApplication.servicesImplementation;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.exceptions.ResourceNotFoundException;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import com.socialMedia.bloggingApplication.services.UserServices;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServicesImpl implements UserServices {


    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDto addUser(UserDto userDto) {
        Users user = this.dtoToUser(userDto);
        Users savedUser = this.usersRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        Users getUser = this.usersRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Users","id",userId));
        getUser.setUserName(userDto.getUserName());
        getUser.setUserAddress(userDto.getUserAddress());
        getUser.setUserEmail(userDto.getUserEmail());
        Users updatedUser = this.usersRepository.save(getUser);
        UserDto userDto1= this.userToDto(updatedUser);
        return userDto1;

    }

    @Override
    public UserDto getUserById(String userId) {
        Users user = this.usersRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Users","id",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users=this.usersRepository.findAll();
        List<UserDto> userDtos =users.stream().map(user ->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(String userId) {
        Users user=this.usersRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Users","id",userId));
        this.usersRepository.delete(user);
    }

    private Users dtoToUser(UserDto userDto){
        Users user = new Users();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserAddress(userDto.getUserAddress());
        user.setComments(userDto.getComments());
        return user;

    }
    private UserDto userToDto(Users user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserEmail(user.getUserEmail());
        userDto.setUserAddress(user.getUserAddress());
        userDto.setComments(user.getComments());
        return userDto;

    }
}
