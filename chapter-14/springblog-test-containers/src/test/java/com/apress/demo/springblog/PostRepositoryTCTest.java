package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.
        Replace.NONE)
class PostRepositoryTCTest {
    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer
            ("mysql:8.0.29");

    @Autowired
    private PostRepository postRepository;

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::
                getUsername);
        registry.add("spring.datasource.password", mySQLContainer::
                getPassword);
    }

    @Test
    void testPostBySlug() {
        setup();
        Optional<Post> postOptional = postRepository.findBySlug("test");
        Assertions.assertTrue(postOptional.isPresent());
        Assertions.assertEquals(1L, postOptional.get().getId());
        Assertions.assertEquals("Test", postOptional.get().getTitle());
    }

    private void setup() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test");
        post.setDescription("Test");
        post.setSlug("test");
        postRepository.save(post);
    }
}
