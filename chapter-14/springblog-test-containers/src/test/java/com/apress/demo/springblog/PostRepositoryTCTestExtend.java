package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.
        Replace.NONE)
public class PostRepositoryTCTestExtend extends BaseTest {

    @Autowired
    private PostRepository postRepository;

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
