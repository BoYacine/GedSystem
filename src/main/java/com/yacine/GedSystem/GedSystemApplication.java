package com.yacine.GedSystem;

import com.yacine.GedSystem.UserManagement.Entity.User;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GedSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GedSystemApplication.class, args);
	}

}
