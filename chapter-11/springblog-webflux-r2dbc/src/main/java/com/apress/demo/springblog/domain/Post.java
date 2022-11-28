package com.apress.demo.springblog.domain;

import com.apress.demo.springblog.validation.BlogPostTitleAlreadyExists;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@BlogPostTitleAlreadyExists
public class Post {
    @Id
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    private String body;
    private String slug;
    @NonNull
    private PostStatus postStatus;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}

