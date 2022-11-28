package com.apress.demo.springblog;

import com.apress.demo.springblog.controller.PostHandler;
import com.apress.demo.springblog.domain.PostStatus;
import com.apress.demo.springblog.dto.PostDto;
import com.apress.demo.springblog.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest(controllers = PostHandler.class)
class PostControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private PostService postService;

    @Test
    void testFindAllPosts() {
        PostDto post = new PostDto();
        post.setTitle("title");
        post.setBody("body");
        post.setDescription("description");
        post.setPostStatus(PostStatus.DRAFT);

        PostDto secondPost = new PostDto();
        secondPost.setTitle("title2");
        secondPost.setBody("body2");
        secondPost.setDescription("description2");
        secondPost.setPostStatus(PostStatus.DRAFT);

        BDDMockito.when(postService.findAllPosts()).thenReturn(Flux.just(post, secondPost));

        webTestClient.get().uri("/api/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.[0].title").isEqualTo("title")
                .jsonPath("$.[1].title").isEqualTo("title2");
    }
}
