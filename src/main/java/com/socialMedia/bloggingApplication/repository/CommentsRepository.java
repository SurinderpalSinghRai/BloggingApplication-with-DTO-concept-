package com.socialMedia.bloggingApplication.repository;

import com.socialMedia.bloggingApplication.entities.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comments,String> {
}
