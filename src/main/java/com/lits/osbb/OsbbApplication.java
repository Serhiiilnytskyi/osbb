package com.lits.osbb;

import com.lits.osbb.config.WeatherAppProperties;
import com.lits.osbb.repository.OsbbRepository;
import com.lits.osbb.repository.RoleRepository;
import com.lits.osbb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(WeatherAppProperties.class)
public class OsbbApplication implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OsbbRepository osbbRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OsbbApplication.class, args);
    }

    //Adding new default User for testing
    //TODO delete when production
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Role role = new Role();
//
//        role.setName("ADMIN");
//
//        User user = new User();
//                user.setFirstName("admin");
//                user.setSecondName("admin");
//                user.setEmail("admin@gmail.com");
//                user.setRoles(new HashSet<Role>() {{
//                    add(role);
//                }});
//                user.setPassword(passwordEncoder.encode("admin"));
//                Osbb osbb = new Osbb();
//                osbb.setName("SomeOsbb");
//        osbbRepository.save(osbb);
//                user.setOsbb(osbb);
//
//
//
//        roleRepository.save(role);
//        userRepository.save(user);

    }
}
