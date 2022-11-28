package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Repository
public class PostRepository {

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
                .orElseThrow(() -> new SpringBlogException("Cannot find post by id: " + postId));
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
