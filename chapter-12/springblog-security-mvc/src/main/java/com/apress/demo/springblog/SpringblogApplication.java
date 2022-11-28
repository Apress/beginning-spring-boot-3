package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.User;
import com.apress.demo.springblog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringblogApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SpringblogApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User user = User.builder()
                    .email("admin@gmail.com")
                    .userName("admin")
                    .password(passwordEncoder.encode("password"))
                    .role("ROLE_ADMIN")
                    .build();
            userRepository.save(user);
        }
    }
}
