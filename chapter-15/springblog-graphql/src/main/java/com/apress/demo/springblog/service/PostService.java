package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.PostInput;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.mapper.PostMapper;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostInput createPost(PostInput postInput) {
        Post post = postMapper.mapToPost(postInput);
        post.setUpdatedOn(LocalDateTime.now());
        post.setCreatedOn(LocalDateTime.now());
        postRepository.save(post);
        return postMapper.mapToPostDto(post);
    }

    public List<PostInput> findAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::mapToPostDto).toList();
    }

    public PostInput findOnePost(String title) {
        Post post = postRepository.findByTitle(title)
                .orElseThrow(() -> new SpringBlogException("Cannot find Post by Title: " + title));
        return postMapper.mapToPostDto(post);
    }

    public PostInput updatePost(PostInput postInput) {
        Post post = postRepository.findById(postInput.getId())
                .orElseThrow(() -> new SpringBlogException("Cannot find Post by Id: " + postInput.getId()));
        post.setId(postInput.getId());
        post.setUpdatedOn(LocalDateTime.now());
        post.setTitle(postInput.getTitle());
        post.setDescription(postInput.getDescription());
        post.setBody(postInput.getBody());
        post.setSlug(postInput.getSlug());
        post.setPostStatus(postInput.getPostStatus());
        postRepository.save(post);
        return postMapper.mapToPostDto(post);
    }

    public void deletePost(String title) {
        postRepository.deleteByTitle(title);
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }

}
