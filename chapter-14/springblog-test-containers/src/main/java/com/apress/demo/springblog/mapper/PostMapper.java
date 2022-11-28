package com.apress.demo.springblog.mapper;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToPost(PostDto postInput) {
        return Post.builder()
                .title(postInput.getTitle())
                .description(postInput.getDescription())
                .body(postInput.getBody())
                .slug(postInput.getSlug().toLowerCase().replace(" ", "_"))
                .postStatus(postInput.getPostStatus())
                .build();
    }

    public PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .body(post.getBody())
                .slug(post.getSlug())
                .postStatus(post.getPostStatus())
                .build();
    }
}
