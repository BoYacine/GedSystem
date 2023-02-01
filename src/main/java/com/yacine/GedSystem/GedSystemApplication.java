package com.yacine.GedSystem;

import com.yacine.GedSystem.FolderManagement.Entity.Folder;
import com.yacine.GedSystem.FolderManagement.Repository.FolderRepo;
import com.yacine.GedSystem.FolderManagement.Service.FolderServiceImpl;
import com.yacine.GedSystem.UserManagement.Entity.UserInfo;
import com.yacine.GedSystem.UserManagement.Repository.UserRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
@AllArgsConstructor
@OpenAPIDefinition
public class GedSystemApplication implements ApplicationRunner {

    UserRepo userRepo;

    PasswordEncoder passwordEncoder;

    FolderServiceImpl folderService;

    FolderRepo folderRepo;


    public static void main(String[] args) {
        SpringApplication.run(GedSystemApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args)  {
        if (userRepo.findAll().isEmpty()) {
			log.info("admin creation");
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("yacine");
            userInfo.setPassword(passwordEncoder.encode("12345"));
            userInfo.setRoles("ROLE_ROOT");
            userInfo.setDependency(folderService.ROOT);
            userRepo.save(userInfo);
            log.info(""+userInfo.getId());

            Folder root=new Folder();
            root.setName("root");
            root.setPath(folderService.ROOT);
            root.setPointer(0);
            root.setUserInfo(userInfo);
            folderRepo.save(root);

            Folder home=new Folder();
            home.setName("home");
            home.setPath(folderService.HOME);
            home.setPointer(1);
            home.setUserInfo(userInfo);
            folderRepo.save(home);

            Folder organization=new Folder();
            organization.setName("organization");
            organization.setPath(folderService.ORGANIZATION);
            organization.setPointer(2);
            organization.setUserInfo(userInfo);
            folderRepo.save(organization);
            log.info(""+organization);
        }
    }

}
