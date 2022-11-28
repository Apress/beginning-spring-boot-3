package com.apress.demo.springblog.service;

import com.apress.demo.springblog.dto.PostDto;
import com.apress.demo.springblog.repository.PostJdbcDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostJdbcDataRepository postRepository;

    public void addPost(PostDto postDto) {
        postDto.setCreatedOn(LocalDate.now());
        postDto.setUpdatedOn(LocalDate.now());
        postRepository.save(PostDto.toPost(postDto));
    }

    public Set<PostDto> findAllPosts() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .map(PostDto::toPostDto).collect(Collectors.toSet());
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findByTitle(title).isPresent();
    }
}
