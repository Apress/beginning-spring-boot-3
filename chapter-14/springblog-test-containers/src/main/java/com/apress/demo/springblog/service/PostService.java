package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.PostDto;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.mapper.PostMapper;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostDto save(PostDto postDto) {
        Post post = postMapper.mapToPost(postDto);
        post.setCreatedOn(LocalDateTime.now());
        post.setUpdatedOn(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        postDto.setId(savedPost.getId());
        return postDto;
    }

    public List<PostDto> findAllPosts() {
        return postRepository.findAll().stream().map(postMapper::mapToPostDto).toList();
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.existsByTitle(title);
    }

    public PostDto update(PostDto postDto) {
        Post savedPost = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new SpringBlogException("Cannot find Post with Id " + postDto.getId()));
        Post post = postMapper.mapToPost(postDto);
        post.setId(savedPost.getId());
        post.setUpdatedOn(LocalDateTime.now());
        postRepository.save(post);
        return postDto;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public PostDto findBySlug(String slug) {
        Post post = postRepository.findBySlug(slug)
                .orElseThrow(() -> new SpringBlogException("Cannot find Post with Slug - " + slug));
        return postMapper.mapToPostDto(post);
    }
}
