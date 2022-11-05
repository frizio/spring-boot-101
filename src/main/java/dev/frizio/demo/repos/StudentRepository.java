package dev.frizio.demo.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import dev.frizio.demo.domanis.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

  List<Student> findByName(String name);
  List<Student> findByNameAndEmail (String name, String email);
  List<Student> findByNameOrEmail (String name, String email);


  List<Student> findByDepartmentName(String deptName);
  List<Student> findBySubjectsName (String subName);


  List<Student> findByEmailIsLike (String email);
  List<Student> findByNameStartsWith (String name);
  

  @Query("{name: ?0}")
  List<Student> getByName(String name);

}
