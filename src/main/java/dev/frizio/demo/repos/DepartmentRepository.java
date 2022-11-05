package dev.frizio.demo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.frizio.demo.domanis.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
  
}
