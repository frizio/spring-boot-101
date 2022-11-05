package dev.frizio.demo.domanis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    private String id;

    private String name;
    private int mark;
  
}
