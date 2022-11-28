package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.JdbcPostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@JdbcTest
@Import(JdbcPostRepository.class)
class JdbcRepositoryTest {

    @Autowired
    private JdbcPostRepository postRepository;

    @Test
    void testFindAllPosts() {
        Post post = new Post();
        post.setTitle("sample blog post");
        post.setDescription("sample blog post");
        post.setBody("sample blog post");
        post.setSlug("sample-blog-post");
        post.setUpdatedOn(LocalDate.now());
        post.setCreatedOn(LocalDate.now());
        postRepository.addPost(post);

        Assertions.assertThat(postRepository.findAllPosts()).hasSize(1);
    }
}
