/**
 * 
 */
package com.apress.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

}
