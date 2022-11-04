package dev.frizio.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.frizio.demo.domanis.Student;
import dev.frizio.demo.repos.StudentRepository;
import dev.frizio.demo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
  
  @Autowired
  StudentRepository studentRepository;


  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student createStudent (Student student) {
    return studentRepository.save(student);
  }
  
  public Student getStudentbyId(String id) {
    return studentRepository.findById(id).get();
  }
  
  public Student updateStudent (Student student) {
    return studentRepository.save(student);
  }
  
  public String deleteStudent (String id) {
    studentRepository.deleteById(id);
    return "Student has been deleted.";
  }

}
