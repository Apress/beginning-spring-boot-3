/**
 * 
 */
package com.apress.demo.repositories;

import com.apress.demo.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Siva
 *
 */
@JdbcTest
public class JdbcUserRepositoryTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private JdbcUserRepository userRepository;

	@BeforeEach
	public void init() {
		userRepository = new JdbcUserRepository(jdbcTemplate);

		jdbcTemplate.execute("create table people(id int, name varchar(100))");
		jdbcTemplate.execute("insert into people(id, name) values(1, 'John')");
		jdbcTemplate.execute("insert into people(id, name) values(2, 'Remo')");
		jdbcTemplate.execute("insert into people(id, name) values(3, 'Dale')");
	}

	@Test
	public void testFindAllUsers() throws Exception {
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isEqualTo(3);
	}

}
