package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.dto.PostDto;
import com.apress.demo.springblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class PostHandler {
    private final PostService postService;

    public Mono<ServerResponse> listPosts(ServerRequest serverRequest) {
        Flux<PostDto> allPosts = postService.findAllPosts();
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allPosts, PostDto.class)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> findPostBySlug(ServerRequest serverRequest) {
        String slug = serverRequest.pathVariable("slug");
        Mono<PostDto> postBySlug = postService.findBySlug(slug);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return postBySlug.flatMap(post -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(post)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> savePost(ServerRequest serverRequest) {
        Mono<PostDto> postDtoMono = serverRequest.bodyToMono(PostDto.class);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return postDtoMono.flatMap(postDto ->
                        ServerResponse
                                .status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postService.save(postDto), PostDto.class))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> updatePost(ServerRequest serverRequest) {
        Mono<PostDto> postDtoMono = serverRequest.bodyToMono(PostDto.class);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return postDtoMono.flatMap(postDto ->
                        ServerResponse
                                .status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(postService.update(postDto), PostDto.class))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> deletePost(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        return ServerResponse
                .status(HttpStatus.NO_CONTENT)
                .build(postService.delete(id))
                .switchIfEmpty(notFound);
    }
}
