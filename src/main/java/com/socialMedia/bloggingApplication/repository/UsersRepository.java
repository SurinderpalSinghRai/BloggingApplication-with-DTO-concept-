package com.socialMedia.bloggingApplication.repository;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.payloads.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends MongoRepository<Users,String> {

}
