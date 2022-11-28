package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.dto.UserForm;
import com.apress.demo.springblog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/register")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    public String doRegister(@Valid @ModelAttribute("userForm") UserForm userForm) {
        userService.registerUser(userForm);
        return "redirect:/login";
    }
}
