package com.apress.demo.springblog;

import com.apress.demo.springblog.controller.PostHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class SpringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routes(PostHandler postHandler) {
        return
                nest(path("/api/posts"),
                        nest(accept(MediaType.APPLICATION_JSON),
                                route(GET("/{slug}"), postHandler::findPostBySlug)
                                        .andRoute(method(HttpMethod.GET), postHandler::listPosts)
                                        .andRoute(DELETE("/{id}"), postHandler::deletePost)
                                        .andRoute(POST("/"), postHandler::savePost)
                                        .andRoute(PUT("/"), postHandler::updatePost)));

    }
}
