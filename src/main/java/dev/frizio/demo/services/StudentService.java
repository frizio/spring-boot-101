package dev.frizio.demo.services;

import java.util.List;

import dev.frizio.demo.domanis.Student;

public interface StudentService {

  public List<Student> getAllStudents();
  public Student createStudent (Student student);
  public Student getStudentbyId(String id);
  public Student updateStudent (Student student);
  public String  deleteStudent (String id);

}
