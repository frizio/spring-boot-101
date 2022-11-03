package dev.frizio.demo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return userMongoRepository.findAll()
                .collectList()
                .map(users -> {
                    if(users.isEmpty()) {
                        return ResponseEntity.noContent().build();
                    }
                    return ResponseEntity.ok(users);
                });
    }

}
