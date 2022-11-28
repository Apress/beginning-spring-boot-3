package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.User;
import com.apress.demo.springblog.dto.UserForm;
import com.apress.demo.springblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserForm userForm) {
        User user = userForm.toUser(userForm);
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(user);
    }
}
