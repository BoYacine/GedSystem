package com.yacine.GedSystem;

import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class GedSystemApplication implements ApplicationRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(GedSystemApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (userRepo.findAll().isEmpty()) {
			log.info("admin creation");
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("yacine");
            userInfo.setPassword(passwordEncoder.encode("12345"));
            userInfo.setRoles("ROLE_ADMIN");
            userRepo.save(userInfo);
        }
    }
}
