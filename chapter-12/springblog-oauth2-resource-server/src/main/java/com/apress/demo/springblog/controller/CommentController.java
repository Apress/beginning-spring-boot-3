package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.dto.CommentDto;
import com.apress.demo.springblog.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/post/{slug}")
    public List<CommentDto> findAllCommentsByPost(@PathVariable String slug) {
        return commentService.findByPost(slug);
    }

    @PostMapping("/post/{slug}")
    public void createComment(@Valid @RequestBody CommentDto commentDto, @PathVariable String slug) {
        commentService.create(commentDto, slug);
    }
}
