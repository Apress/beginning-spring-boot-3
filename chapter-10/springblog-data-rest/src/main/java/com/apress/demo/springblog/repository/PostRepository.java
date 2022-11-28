package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {


    boolean existsByTitle(String title);

    Optional<Post> findBySlug(String slug);
}
