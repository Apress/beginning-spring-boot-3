package com.apress.demo.springblog.mapper;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.PostInput;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPost(PostInput postInput) {
        return Post.builder()
                .title(postInput.getTitle())
                .description(postInput.getDescription())
                .body(postInput.getBody())
                .slug(postInput.getSlug())
                .postStatus(postInput.getPostStatus())
                .build();
    }

    public PostInput mapToPostDto(Post post) {
        return PostInput.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .body(post.getBody())
                .slug(post.getSlug())
                .postStatus(post.getPostStatus())
                .build();
    }
}
