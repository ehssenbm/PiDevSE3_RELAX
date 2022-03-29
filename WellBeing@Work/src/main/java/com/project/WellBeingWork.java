package com.project;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.entities.Role;
import com.project.entities.User;
import com.project.services.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication
public class WellBeingWork {
	public static void main(String[] args) {
		SpringApplication.run(WellBeingWork.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ENTREPRISE"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "seyf","cherni","seyf cherni", "seyf","seyf.cherni@esprit.tn ", "1234", new ArrayList<>()));
			userService.addRoleToUser("wassim", "ROLE_SUPER_ADMIN");
			
		};
	}*/


}
