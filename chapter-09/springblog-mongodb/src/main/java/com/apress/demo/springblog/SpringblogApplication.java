package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.domain.PostStatus;
import com.apress.demo.springblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringblogApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Post post = Post.builder()
                .title("Sample Blog Post")
                .description("Sample Blog Post")
                .body("Sample Blog Post")
                .slug("sample_blog_post")
                .postStatus(PostStatus.DRAFT)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
        postRepository.save(post);
    }

}
