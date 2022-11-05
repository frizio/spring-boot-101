package dev.frizio.demo.domanis;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  private String id;

  private String name;
  
  @Field(name = "email")
  private String email;

  private Department department;

  private List<Subject> subjects;
  
  @Transient
  private double percentage;

  public double getPercentage() {
    if (subjects != null && subjects.size() > 0) {
      int total = 0;
      for (Subject subject : subjects) {
        total += subject.getMark();
      }
      return total/subjects.size();
    }
    return 0.00;
  }
  
  
}
