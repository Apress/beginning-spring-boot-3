
package com.apress.demo.services;

import com.apress.demo.entities.User;
import com.apress.demo.exceptions.UserImportServiceCommunicationFailure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */

@Service
public class UsersImporter
{

	public List<User> importUsers() throws UserImportServiceCommunicationFailure
	{
		//Here 
		List<User> users = new ArrayList<>();
		//get users by invoking some web service
		//if any exception occurs throw UserImportServiceCommunicationFailure
		
		//dummy data
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		return users;
	}

}
