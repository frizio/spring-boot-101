package dev.frizio.demo.domains;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    @NotBlank
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
