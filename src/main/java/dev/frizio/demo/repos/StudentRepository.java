package dev.frizio.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frizio.demo.domanis.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
  
}
