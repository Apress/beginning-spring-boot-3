package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.domain.PostStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RawJdbcPostRepository {

    private final DataSource dataSource;

    public Optional<Post> findById(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "select id, title, description, body, slug, post_status, created_on, updated_on from posts where id=?");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Post post = null;
            if(resultSet.next()) {
                post = new Post(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("body"),
                        resultSet.getString("slug"),
                        PostStatus.valueOf(resultSet.getString("post_status")),
                        convertToLocalDate(resultSet.getDate("created_on")),
                        convertToLocalDate(resultSet.getDate("updated_on"))
                        );
            }
            return Optional.of(post);
        } catch (SQLException e) {
            // ??? What should be done here ???
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {}
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return Optional.empty();
    }

    private LocalDate convertToLocalDate(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.toLocalDate();
        }
    }
}
