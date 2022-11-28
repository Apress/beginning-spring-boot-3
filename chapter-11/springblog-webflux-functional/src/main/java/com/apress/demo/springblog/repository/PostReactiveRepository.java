package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface PostReactiveRepository extends ReactiveCrudRepository<Post, String> {
    Mono<Boolean> existsByTitle(String title);

    Mono<Post> findBySlug(String slug);
}
