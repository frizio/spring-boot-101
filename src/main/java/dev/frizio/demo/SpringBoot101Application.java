package dev.frizio.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.frizio.demo.domains.User;
import dev.frizio.demo.repos.UserMongoRepository;

@SpringBootApplication
// @EnableMongoRepositories(basePackages = "dev.frizio.demo.repos")
public class SpringBoot101Application {

  /**
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringBoot101Application.class, args);
  }

  @Bean
  public CommandLineRunner insertData(UserMongoRepository userMongoRepository) {
  System.out.println("*********************** Execute CommandLineRunner ***********************");
  userMongoRepository.deleteAll().subscribe();
    return args -> {
        userMongoRepository.save(new User("Vincenzo", "Racca")).subscribe();
        userMongoRepository.save(new User("Mario", "Rossi")).subscribe();
        userMongoRepository.save(new User("Gennaro", "Esposito")).subscribe();
        userMongoRepository.save(new User("Diego", "della Lega")).subscribe();
    };
  }

}
