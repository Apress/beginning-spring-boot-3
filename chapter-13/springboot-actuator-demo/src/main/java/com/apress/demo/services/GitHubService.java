/**
 * 
 */
package com.apress.demo.services;

import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.apress.demo.models.GitHubUser;

/**
 * @author Siva
 *
 */
@Service
public class GitHubService {

	@Timed("guthub.response-time")
	public GitHubUser getUserInfo(String username)
	{
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.github.com/users/"+username;
		GitHubUser gitHubUser = null;
		try {
			gitHubUser = restTemplate.getForObject(url , GitHubUser.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return gitHubUser;
	}
}
