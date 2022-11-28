package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PostReactiveRepository extends ReactiveCrudRepository<Post, Long> {
    Mono<Boolean> existsByTitle(String title);

    Mono<Post> findBySlug(String slug);
}
