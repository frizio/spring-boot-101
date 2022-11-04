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
  
  
}
