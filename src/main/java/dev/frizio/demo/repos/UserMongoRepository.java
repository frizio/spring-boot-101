package dev.frizio.demo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import dev.frizio.demo.domains.User;

public interface UserMongoRepository extends ReactiveMongoRepository<User, String> {

}
