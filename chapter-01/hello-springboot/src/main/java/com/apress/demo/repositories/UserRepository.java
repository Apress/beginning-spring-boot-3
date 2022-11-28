/**
 * 
 */
package com.apress.demo.repositories;

import com.apress.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

}
