package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JooqTest
@Import(PostRepository.class)
class PostRepositoryJooqTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void findAllPosts() {
        Post post = new Post();
        post.setTitle("Test2");
        post.setDescription("Test2");
        postRepository.addPost(post);
        List<Post> posts = postRepository.findAllPosts();
        assertNotNull(posts);
        assertFalse(posts.isEmpty());
    }

    @Test
    void findPostById() {
        Post post = new Post();
        post.setTitle("Test1");
        post.setDescription("Test1");
        postRepository.addPost(post);
        Post post1 = postRepository.findOnePost(1)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find any post withd id 1"));
        assertNotNull(post1);
    }

    @Test
    void createPost() {
        Post post = new Post();
        post.setTitle("Test");
        post.setDescription("Test");
        postRepository.addPost(post);
        assertTrue(postRepository.findAllPosts()
                .stream()
                .anyMatch(savedPost -> savedPost.getTitle().equals(post.getTitle())));
    }
}
