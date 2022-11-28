package com.apress.demo.springblog.dto;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.domain.PostStatus;
import com.apress.demo.springblog.validation.BlogPostTitleAlreadyExists;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@BlogPostTitleAlreadyExists
public class PostDto {
    private String id;
    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimum 3 characters, and maximum 50 characters long")
    private String title;
    @NotNull
    @Size(min = 3, max = 500, message = "Description must be minimum 3 characters, and maximum 500 characters long")
    private String description;
    @NotNull
    @Size(min = 3, max = 5000, message = "Body must be minimum 3 characters, and maximum 5000 characters long")
    private String body;
    private String slug;
    private PostStatus postStatus;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private MultipartFile coverPhoto;

    public static Post toPost(PostDto postForm) {
        return Post.builder()
                .title(postForm.title)
                .description(postForm.description)
                .body(postForm.body)
                .slug(postForm.slug)
                .createdOn(postForm.createdOn)
                .updatedOn(postForm.updatedOn)
                .postStatus(postForm.postStatus)
                .build();
    }

    public static PostDto toPostDto(Post postForm) {
        return PostDto.builder()
                .title(postForm.getTitle())
                .description(postForm.getDescription())
                .body(postForm.getBody())
                .slug(postForm.getSlug())
                .createdOn(postForm.getCreatedOn())
                .updatedOn(postForm.getUpdatedOn())
                .postStatus(postForm.getPostStatus())
                .build();
    }
}
