package dev.frizio.demo.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frizio.demo.domanis.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

  List<Student> findByName(String name);

  List<Student> findByNameAndEmail (String name, String email);
	
	List<Student> findByNameOrEmail (String name, String email);
  
}
