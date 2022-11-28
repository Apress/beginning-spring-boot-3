package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String postPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "post";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        postService.addPost(post);
        return "redirect:/posts";
    }

    @ExceptionHandler(SpringBlogException.class)
    public ModelAndView handleSpringBlogException(SpringBlogException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("exception", ex);
        return model;
    }

}
