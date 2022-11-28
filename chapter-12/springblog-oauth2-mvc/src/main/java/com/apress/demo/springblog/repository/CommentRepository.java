package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CommentRepository {
    private final Set<Post> posts = new CopyOnWriteArraySet<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public Set<Post> findAllPosts() {
        return posts;
    }

    public Post findOnePost(Integer postId) {
        return posts.stream().filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void updatePost(Post post) {
        Post savedPost = findOnePost(post.getId());
        post.setId(savedPost.getId());
        posts.add(post);
    }

    public void deletePost(Integer id) {
        Post onePost = findOnePost(id);
        posts.remove(onePost);
    }
}
