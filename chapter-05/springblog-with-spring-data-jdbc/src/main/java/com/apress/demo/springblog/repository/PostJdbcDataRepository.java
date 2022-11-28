package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostJdbcDataRepository extends CrudRepository<Post, Integer> {
    @Query("select * from posts where title= :title")
    Optional<Object> findByTitle(@Param("title") String title);
}
