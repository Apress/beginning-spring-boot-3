package com.apress.demo.springblog.mapper;

import com.apress.demo.springblog.domain.Comment;
import com.apress.demo.springblog.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment mapToComment(CommentDto commentDto) {
        return Comment.builder()
                .title(commentDto.getTitle())
                .authorName(commentDto.getAuthorName())
                .body(commentDto.getBody())
                .createdOn(commentDto.getCreatedOn())
                .updatedOn(commentDto.getUpdatedOn())
                .build();
    }

    public CommentDto mapToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .title(comment.getTitle())
                .authorName(comment.getAuthorName())
                .body(comment.getBody())
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .build();
    }
}
