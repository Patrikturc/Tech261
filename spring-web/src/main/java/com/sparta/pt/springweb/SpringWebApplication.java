package com.sparta.pt.springweb;

import com.sparta.pt.springweb.entities.User;
import com.sparta.pt.springweb.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			userRepository.save(new User("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
//			userRepository.save(new User("user", passwordEncoder.encode("user"), "ROLE_USER"));
//		};
//	}

}
