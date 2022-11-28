package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.dto.PostInput;
import com.apress.demo.springblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostGraphqlController {
    private final PostService postService;

//    @SchemaMapping(typeName = "Query", value = "allPosts")
//    public List<PostInput> findAllPosts() {
//        return postService.findAllPosts();
//    }

    @QueryMapping
    public List<PostInput> allPosts() {
        return postService.findAllPosts();
    }

    @QueryMapping
    public PostInput onePost(@Argument String title) {
        return postService.findOnePost(title);
    }

    @MutationMapping
    public PostInput createPost(@Argument PostInput postInput) {
        return postService.createPost(postInput);
    }

    @MutationMapping
    public PostInput updatePost(@Argument PostInput postInput) {
        return postService.updatePost(postInput);
    }

    @MutationMapping
    public String deletePost(@Argument String title) {
        postService.deletePost(title);
        return title;
    }
}
