package me.edenlisk.springboottodo.todo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoMongoRepository extends MongoRepository<Todo, ObjectId> {
}
