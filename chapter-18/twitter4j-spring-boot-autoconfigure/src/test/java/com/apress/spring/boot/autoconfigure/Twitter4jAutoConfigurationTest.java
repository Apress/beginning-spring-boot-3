/**
 * 
 */
package com.apress.spring.boot.autoconfigure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Siva
 *
 */
public class Twitter4jAutoConfigurationTest {
	private AnnotationConfigApplicationContext context;

	@BeforeEach
	public void init() {
		this.context = new AnnotationConfigApplicationContext();
	}

	@AfterEach
	public void closeContext() {
		if (this.context != null) {
			this.context.close();
		}
	}

	@Test
	public void testWithTwitter4jProperties(){
		TestPropertyValues.of("twitter4j.oauth.consumer-key:consumer-key-value-here",
				"twitter4j.oauth.consumer-secret:consumer-secret-value-here",
				"twitter4j.oauth.access-token:access-token-value-here",
				"twitter4j.oauth.access-token-secret:access-token-secret-value-here")
				.applyTo(this.context);

		this.context.register(
							  PropertyPlaceholderAutoConfiguration.class,
							  Twitter4jAutoConfiguration.class
							  );
		this.context.refresh();
		assertEquals(1, this.context.getBeanNamesForType(TwitterFactory.class).length);
		assertEquals(1, this.context.getBeanNamesForType(Twitter.class).length);
	}
}
