package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
