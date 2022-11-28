package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findOnePost(String postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Cannot find Post by id - " + postId));
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }
}
