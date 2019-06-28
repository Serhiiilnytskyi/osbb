package com.lits.osbb;

import com.lits.osbb.model.Role;
import com.lits.osbb.model.User;
import com.lits.osbb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class OsbbApplication implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OsbbApplication.class, args);
    }

    //Adding new default User for testing
    //TODO delete when production
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role = new Role();

        role.setName("ADMIN");

        User user = User.builder()
                .firstName("admin")
                .secondName("admin")
                .email("admin@gmail.com")
                .roles(new HashSet<Role>() {{
                    add(role);
                }})
                .password(passwordEncoder.encode("admin"))
                .build();

        userRepository.save(user);

    }
}
