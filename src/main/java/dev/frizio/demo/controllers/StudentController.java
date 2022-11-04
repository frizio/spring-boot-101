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
import org.springframework.web.bind.annotation.RequestParam;
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

  // 
  @GetMapping("/byname")
  public List<Student> getStudentsByName(@RequestParam String name) {
    return studentService.getStudentsByName(name);
  }
  
  @GetMapping("/bynameandemail")
  public List<Student> getStudentsByNameAndEmail(@RequestParam String name, @RequestParam String email) {
    return studentService.getStudentsByNameAndEmail(name, email);
  }
  
  @GetMapping("/bynameoremail")
  public List<Student> getStudentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
    return studentService.getStudentsByNameOrMail(name, email);
  }


  @GetMapping("/withpagination")
  public List<Student> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
    return studentService.getAllStudentsWithPagination(pageNo, pageSize);
  }
  
  @GetMapping("/withsorting")
  public List<Student> getAllStudentsWithSorting() {
    return studentService.getAllStudentsWithSorting();
  }


  @GetMapping("/bydepartmentname")
  public List<Student> getStudentsByDepartmentName(@RequestParam String deptName) {
    return studentService.getStudentsByDepartmentName(deptName);
  }
  
  @GetMapping("/bysubjectname")
  public List<Student> getStudentsBySubjectName(@RequestParam String subName) {
    return studentService.getStudentsBySubjectName(subName);
  }


  @GetMapping("/byEmailLike")
  public List<Student> getStudentsByEmailLike(@RequestParam String email) {
    return studentService.getStudentsByEmailLike(email);
  }
  
  @GetMapping("/byNameStartsWith")
  public List<Student> getStudentsByNameStartsWith(@RequestParam String name) {
    return studentService.getStudentsByNameStartsWith(name);
  }

}
  