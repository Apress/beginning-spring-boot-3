package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
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
        return postRepository.findOnePost(postId);
    }

    public void updatePost(Post post) {
        postRepository.updatePost(post);
    }

    public void deletePost(Integer id) {
        postRepository.deletePost(id);
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findAllPosts().stream()
                .anyMatch(post -> post.getTitle().equals(title));
    }
}
