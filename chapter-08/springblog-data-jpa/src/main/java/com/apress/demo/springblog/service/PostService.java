package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Set<Post> findAllPosts() {
        return new HashSet<>(postRepository.findAll());
    }

    public Post findOnePost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new SpringBlogException("Cannot find Post by Id: " + postId));
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }
}
