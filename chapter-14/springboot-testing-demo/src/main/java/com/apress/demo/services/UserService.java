
package com.apress.demo.services;

import com.apress.demo.entities.User;
import com.apress.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findUserById(Integer userId)
	{
		return userRepository.findById(userId);
	}
	
	@Secured("ROLE_USER")
	public void createUser(User user)
	{
		userRepository.save(user);
	}
	
	//@Secured("IS_AUTHENTICATED_FULLY")
	@PreAuthorize("isAuthenticated()")
	public void updateUser(User user)
	{
		userRepository.save(user);
	}
	
	@Secured("ROLE_ADMIN")
	public void deleteUser(Integer userId)
	{
		userRepository.deleteById(userId);
	}
	
}
