package dev.frizio.demo.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.frizio.demo.domains.User;
import dev.frizio.demo.repos.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserMongoRepository userMongoRepository;

    @GetMapping
    public Mono<ResponseEntity<List<User>>> findAll() {
        return userMongoRepository
                .findAll()
                .collectList()
                .map( users -> {
                    if (users.isEmpty()) {
                        return ResponseEntity.noContent().build();
                    }
                    return ResponseEntity.ok(users);
                  });
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Mono<ResponseEntity<User>> save(/*@Valid*/ @RequestBody User user) {
        return userMongoRepository
                .save(user)
                .map( userSaved -> 
                  UriComponentsBuilder.fromPath(("/{id}"))
                    .buildAndExpand(userSaved.getId())
                    .toUri() 
                  )
                .map( uri -> 
                  ResponseEntity.created(uri).build() 
                );
    }

}
