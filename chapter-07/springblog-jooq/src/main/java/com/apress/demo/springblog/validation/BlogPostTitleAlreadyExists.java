package com.apress.demo.springblog.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BlogPostTitleValidator.class)
public @interface BlogPostTitleAlreadyExists {
    String message() default "{TitleAlreadyExists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
