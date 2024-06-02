package me.edenlisk.springboottodo.appUser;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<AppUser, ObjectId> {
}
