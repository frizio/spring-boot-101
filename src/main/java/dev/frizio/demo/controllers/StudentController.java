package dev.frizio.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.frizio.demo.domanis.Student;
import dev.frizio.demo.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
  
  @Autowired
  StudentService studentService;

  @GetMapping()
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping()
  public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }
  
  @GetMapping("/{id}")
  public Student getStudentbyId(@PathVariable String id) {
    return studentService.getStudentbyId(id);
  }
  
  @PutMapping()
  public Student updateStudent(@RequestBody Student student) {
    return studentService.updateStudent(student);
  }
  
  @DeleteMapping("/{id}")
  public String deleteStudent(@PathVariable String id) {
    return studentService.deleteStudent(id);
  }

}
  