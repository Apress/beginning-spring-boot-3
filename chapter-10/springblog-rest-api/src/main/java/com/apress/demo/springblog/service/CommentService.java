package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Comment;
import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.dto.CommentDto;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.mapper.CommentMapper;
import com.apress.demo.springblog.repository.CommentRepository;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> findByPost(String slug) {
        Post post = getPostBySlug(slug);
        return post.getComments()
                .stream()
                .map(commentMapper::mapToCommentDto)
                .toList();
    }

    public void create(CommentDto commentDto, String slug) {
        Comment comment = commentMapper.mapToComment(commentDto);
        comment.setCreatedOn(LocalDateTime.now());
        comment.setUpdatedOn(LocalDateTime.now());
        Post postBySlug = getPostBySlug(slug);
        comment.setPost(postBySlug);
        commentRepository.save(comment);
        postBySlug.getComments().add(comment);
        postRepository.save(postBySlug);
    }

    private Post getPostBySlug(String slug) {
        return postRepository.findBySlug(slug)
                .orElseThrow(() -> new SpringBlogException("Cannot find post by slug - " + slug));
    }
}
