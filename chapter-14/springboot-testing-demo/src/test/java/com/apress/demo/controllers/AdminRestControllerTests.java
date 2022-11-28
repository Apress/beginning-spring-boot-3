package com.apress.demo.controllers;

import com.apress.demo.SpringbootTestingDemoApplication;
import com.apress.demo.config.WebSecurityConfig;
import com.apress.demo.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Siva
 */
@WebMvcTest(controllers = AdminRestController.class)
@ContextConfiguration(classes = {SpringbootTestingDemoApplication.class, WebSecurityConfig.class})
class AdminRestControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void testAdminDeleteUser() throws Exception {
        Mockito.doNothing()
                .when(userService)
                .deleteUser(Mockito.any(Integer.class));

        this.mvc.perform(delete("/admin/users/2")
                        .with(csrf())
                        .with(user("admin").password("admin123").roles("ADMIN"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteUser(2);
    }

}
