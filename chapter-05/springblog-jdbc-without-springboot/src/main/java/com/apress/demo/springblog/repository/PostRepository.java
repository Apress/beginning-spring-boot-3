package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;

import java.util.Set;

public interface PostRepository {
    void addPost(Post post);

    Set<Post> findAllPosts();
}
