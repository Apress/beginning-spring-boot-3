package com.apress.demo.springblog.dto;

import com.apress.demo.springblog.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {
    @Email
    private String email;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public User toUser(UserForm userForm) {
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setUserName(userForm.getUserName());
        user.setPassword(userForm.getPassword());
        user.setRole("ROLE_USER");
        return user;
    }
}
