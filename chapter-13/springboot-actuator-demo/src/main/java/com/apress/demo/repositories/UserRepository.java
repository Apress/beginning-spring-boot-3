/**
 * 
 */
package com.apress.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apress.demo.entities.User;


/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);

}
