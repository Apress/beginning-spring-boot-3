/**
 * 
 */
package com.apress.demo.repositories;

import com.apress.demo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Siva
 *
 */
@RestResource(exported=false)
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
