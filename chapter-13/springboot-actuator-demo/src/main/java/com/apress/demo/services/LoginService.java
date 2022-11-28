/**
 * 
 */
package com.apress.demo.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

/**
 * @author Siva
 *
 */
@Service
public class LoginService {

	private final Counter successCounter;
	private final Counter failureCounter;

	public LoginService(MeterRegistry registry) {
		this.successCounter = registry.counter("counter.login.success");
		this.failureCounter = registry.counter("counter.login.failure");
	}

	public boolean login(String email, String password)
	{
		if("admin@gmail.com".equalsIgnoreCase(email) && "admin".equals(password)){
			this.successCounter.increment();
			return true;
		} else {
			this.failureCounter.increment();
			return false;
		}
	}
}
