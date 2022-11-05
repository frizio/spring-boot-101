package dev.frizio.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.frizio.demo.domanis.Department;
import dev.frizio.demo.domanis.Student;
import dev.frizio.demo.domanis.Subject;
import dev.frizio.demo.repos.DepartmentRepository;
import dev.frizio.demo.repos.StudentRepository;
import dev.frizio.demo.repos.SubjectRepository;
import dev.frizio.demo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
  
  @Autowired
  StudentRepository studentRepository;

  @Autowired
  DepartmentRepository departmentRepository;

  @Autowired
  SubjectRepository subjectRepository;


  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student createStudent (Student student) {
    Department department = student.getDepartment();
    if (department != null) {
      departmentRepository.save(department);
    }
    List<Subject> subjects = student.getSubjects();
    if (subjects != null && subjects.size() > 0) {
      subjectRepository.saveAll(subjects);
    }
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
    return studentRepository.getByName(name);
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
  public List<Student> getStudentsByDepartmentId(String deptId) {
    return studentRepository.findByDepartmentId(deptId);
  }

  @Override
  public List<Student> getStudentsBySubjectId(String subId) {
    return studentRepository.findBySubjectsId(subId);
  }

  @Override
  public List<Student> getStudentsByEmailLike(String subName) {
    return studentRepository.findByEmailIsLike(subName);
  }

  @Override
  public List<Student> getStudentsByNameStartsWith(String name) {
    return studentRepository.findByNameStartsWith(name);
  }


}
