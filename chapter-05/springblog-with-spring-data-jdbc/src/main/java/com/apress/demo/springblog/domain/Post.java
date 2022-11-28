package com.apress.demo.springblog.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("posts")
public class Post {
    @Id
    private Integer id;
    private String title;
    private String description;
    private String body;
    private String slug;
    private PostStatus postStatus;
    private LocalDate createdOn;
    private LocalDate updatedOn;
}
