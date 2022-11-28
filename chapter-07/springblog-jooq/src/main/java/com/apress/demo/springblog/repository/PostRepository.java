package com.apress.demo.springblog.repository;

import com.apress.demo.jooq.domain.tables.records.PostsRecord;
import com.apress.demo.springblog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.apress.demo.jooq.domain.tables.Posts.POSTS;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final DSLContext dslContext;

    public void addPost(Post post) {
        dslContext.insertInto(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.DESCRIPTION, post.getDescription())
                .set(POSTS.BODY, post.getBody())
                .set(POSTS.SLUG, post.getSlug())
                .returning(POSTS.ID)
                .fetchOne();
    }

    public List<Post> findAllPosts() {
        List<Post> posts = new ArrayList<>();

        Result<Record> recordResult = dslContext.select().from(POSTS).fetch();
        for (Record r : recordResult) {
            posts.add(getPostEntity(r));
        }
        return posts;
    }

    public Optional<Post> findOnePost(Integer postId) {
        Record postRecord = dslContext.select().
                from(POSTS)
                .where(POSTS.ID.eq(postId))
                .fetchOne();
        if (postRecord != null) {
            return Optional.of(getPostEntity(postRecord));
        }
        return Optional.empty();
    }

    private Post getPostEntity(Record r) {
        Integer id = r.getValue(POSTS.ID, Integer.class);
        String title = r.getValue(POSTS.TITLE, String.class);
        String description = r.getValue(POSTS.DESCRIPTION, String.class);
        String body = r.getValue(POSTS.BODY, String.class);
        String slug = r.getValue(POSTS.SLUG, String.class);
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setBody(body);
        post.setSlug(slug);
        return post;
    }

    public void deletePost(Integer postId) {
        dslContext.deleteFrom(POSTS).where(POSTS.ID.equal(postId)).execute();
    }
}
