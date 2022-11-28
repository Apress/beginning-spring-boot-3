package com.apress.demo.springblog.validation;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.service.PostService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public record BlogPostTitleValidator(
        PostService postService) implements ConstraintValidator<BlogPostTitleAlreadyExists, Post> {

    @Override
    public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.isEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{TitleAlreadyExists}")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
