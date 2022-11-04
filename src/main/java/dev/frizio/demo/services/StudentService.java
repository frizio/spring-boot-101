package dev.frizio.demo.services;

import java.util.List;

import dev.frizio.demo.domanis.Student;

public interface StudentService {

  public List<Student> getAllStudents();
  public Student createStudent (Student student);
  public Student getStudentbyId(String id);
  public Student updateStudent (Student student);
  public String  deleteStudent (String id);

  public List<Student> getStudentsByName (String name);
  public List<Student> getStudentsByNameAndEmail (String name, String email);
  public List<Student> getStudentsByNameOrMail (String name, String email);

  public List<Student> getAllStudentsWithPagination (int pageNo, int pageSize);
  public List<Student> getAllStudentsWithSorting ();

  public List<Student> getStudentsByDepartmentName(String deptName);
  public List<Student> getStudentsBySubjectName(String subName);

}
