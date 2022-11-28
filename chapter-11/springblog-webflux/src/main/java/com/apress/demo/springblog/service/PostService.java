package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.PostDto;
import com.apress.demo.springblog.mapper.PostMapper;
import com.apress.demo.springblog.repository.PostReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostReactiveRepository postReactiveRepository;
    private final PostMapper postMapper;

    public Mono<PostDto> save(PostDto postDto) {
        Post post = postMapper.mapToPost(postDto);
        post.setCreatedOn(LocalDateTime.now());
        post.setUpdatedOn(LocalDateTime.now());
        return postReactiveRepository.save(post).map(p -> {
                    postDto.setId(p.getId());
                    return postDto;
                }
        );
    }

    public Flux<PostDto> findAllPosts() {
        return postReactiveRepository.findAll()
                .map(postMapper::mapToPostDto)
                .switchIfEmpty(Flux.empty());
    }

    public Mono<Boolean> postExistsWithTitle(String title) {
        return postReactiveRepository.existsByTitle(title);
    }

    public Mono<PostDto> update(PostDto postDto) {
        return postReactiveRepository.findById(postDto.getId())
                .flatMap(savedPost -> {
                    Post post = postMapper.mapToPost(postDto);
                    post.setId(savedPost.getId());
                    return postReactiveRepository.save(post);
                })
                .map(postMapper::mapToPostDto);
    }

    public Mono<Void> delete(String id) {
        return postReactiveRepository.deleteById(id);
    }

    public Mono<PostDto> findBySlug(String slug) {
        Mono<Post> postMono = postReactiveRepository.findBySlug(slug);
        return postMono.map(postMapper::mapToPostDto);
    }
}
