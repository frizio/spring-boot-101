package dev.frizio.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


  public List<Student> getStudentsByName (String name) {
    return studentRepository.findByName(name);
  }
  
  public List<Student> getStudentsByNameAndEmail (String name, String email) {
    return studentRepository.findByNameAndEmail(name, email);
  }
  
  public List<Student> getStudentsByNameOrMail (String name, String email) {
    return studentRepository.findByNameOrEmail(name, email);
  }


  public List<Student> getAllStudentsWithPagination (int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return studentRepository.findAll(pageable).getContent();
  }
  
  public List<Student> getAllStudentsWithSorting () {
    Sort sort = Sort.by(Sort.Direction.DESC, "name", "email");
    return studentRepository.findAll(sort);
  }

  @Override
  public List<Student> getStudentsByDepartmentName(String deptName) {
    return studentRepository.findByDepartmentName(deptName);
  }

  @Override
  public List<Student> getStudentsBySubjectName(String subName) {
    return studentRepository.findBySubjectsName(subName);
  }


}
