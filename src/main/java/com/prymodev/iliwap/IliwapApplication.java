package com.prymodev.iliwap;

import com.prymodev.iliwap.entity.AppRole;
import com.prymodev.iliwap.repository.RoleRepository;
import com.prymodev.iliwap.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class IliwapApplication {

    public static void main(String[] args) {
        SpringApplication.run(IliwapApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService, RoleRepository roleRepository) {

        return args -> {
            roleRepository.deleteAll();
            userService.saveRole(new AppRole(null, "USER"));
            userService.saveRole(new AppRole(null, "ADMIN"));
        };
    }

}
