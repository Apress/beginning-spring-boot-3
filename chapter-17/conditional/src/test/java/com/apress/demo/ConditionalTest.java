package com.apress.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author Siva
 *
 */
@ContextConfiguration(classes = AppConfig.class)
@ExtendWith(SpringExtension.class)
class ConditionalTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    void test_get_all_usernames() {
        List<String> userNames = userDAO.getAllUserNames();
        System.err.println(userNames);
    }
}
