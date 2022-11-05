package dev.frizio.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frizio.demo.domanis.Subject;

public interface SubjectRepository extends MongoRepository<Subject, String> {
  
}
