package com.apress.demo.springblog;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.domain.PostStatus;
import com.apress.demo.springblog.dto.PostInput;
import com.apress.demo.springblog.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureHttpGraphQlTester
class SpringblogApplicationTests {

    @Autowired
    private HttpGraphQlTester httpGraphQlTester;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void setup() {
        // Setup clean Test Data
        postRepository.deleteAll();
        Post post = new Post(1L, "Title", "Description", "Body", "title",
                PostStatus.DRAFT, LocalDateTime.now(), LocalDateTime.now(), null);
        postRepository.save(post);
    }

    @Test
    void shouldFindAllPosts() {

        // language=GraphQL
        String document = """
                    query {
                         allPosts {
                           id,
                           title,
                           body
                         }
                     }
                     
                """;

        httpGraphQlTester.document(document)
                .execute()
                .path("allPosts")
                .entityList(PostInput.class)
                .hasSize(1);
    }

    @Test
    void shouldFindOnePost() {
        // language=GraphQL
        String document = """
                    query {
                        onePost(title: "Title") {
                             id
                             title
                             body
                         }
                    }
                """;

        PostInput expectedPost = new PostInput(1L, "Title", "Content", "Body", "title", PostStatus.DRAFT);

        httpGraphQlTester.document(document)
                .execute()
                .path("onePost")
                .entity(PostInput.class)
                .satisfies(postDto -> {
                    assertEquals(expectedPost.getTitle(), postDto.getTitle());
                    assertEquals(expectedPost.getBody(), postDto.getBody());
                });
    }

    @Test
    void shouldCreatePost() {
        // language=GraphQL
        String document = """
                    mutation {
                createPost(
                  postInput: { title: "Spring Boot11", description: "Spring Boot11", body: "Spring Boot11",\s
                 slug: "spring_boot11", postStatus: "DRAFT" }
                          ) {
                              id
                              title
                              body
                          }

                                    }
                """;

        PostInput expectedPost = new PostInput(2L, "Spring Boot11", "Spring Boot11", "Spring Boot11",
                "spring_boot11", PostStatus.DRAFT);

        httpGraphQlTester.document(document)
                .execute()
                .path("createPost")
                .entity(PostInput.class)
                .satisfies(postDto -> {
                    assertEquals(expectedPost.getTitle(), postDto.getTitle());
                    assertEquals(expectedPost.getBody(), postDto.getBody());
                });
    }

    @Test
    void shouldUpdatePost() {
        // language=GraphQL
        String document = """
                    mutation {
                      updatePost(postInput: {id:1,title: "Title 1", description: "GraphQL Spring Boot Updated", body: "Spring Boot11",slug: "spring_boot11", 
                      postStatus: "DRAFT" }) {
                        id
                        title
                        body
                      }
                    }
                """;

        PostInput expectedPost = new PostInput(1L, "Title 1", "GraphQL Spring Boot Updated", "Spring Boot11",
                null, PostStatus.DRAFT);

        httpGraphQlTester.document(document)
                .execute()
                .path("updatePost")
                .entity(PostInput.class)
                .satisfies(postDto -> {
                    assertEquals(expectedPost.getTitle(), postDto.getTitle());
                    assertEquals(expectedPost.getBody(), postDto.getBody());
                });
    }

    @Test
    void shouldDeletePost() {
        // language=GraphQL
        String document = """
                mutation {
                    deletePost(title: "Title")
                }
                """;

        httpGraphQlTester.document(document)
                .execute()
                .path("deletePost")
                .entity(String.class)
                .satisfies(title -> assertEquals("Title", title));

        assertFalse(postRepository.findByTitle("Title").isPresent());
    }

}
