package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.
        Replace.NONE)
class PostRepositoryTCManualStartupTest {
    static MySQLContainer<?> mysqlContainer =
            new MySQLContainer<>(DockerImageName.parse("mysql:8.0.29"));
    @Autowired
    private PostRepository postRepository;

    @BeforeAll
    static void beforeAll() {
        mysqlContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mysqlContainer.stop();
    }

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::
                getUsername);
        registry.add("spring.datasource.password", mysqlContainer::
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
