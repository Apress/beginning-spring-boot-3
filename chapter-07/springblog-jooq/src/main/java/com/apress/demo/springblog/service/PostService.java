package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    public List<Post> findAllPosts() {
        return new ArrayList<>(postRepository.findAllPosts());
    }

    public Post findOnePost(Integer postId) {
        return postRepository.findOnePost(postId)
                .orElseThrow(() -> new SpringBlogException("Cannot find post by id: " + postId));
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findAllPosts().stream()
                .anyMatch(post -> post.getTitle().equals(title));
    }
}
