package com.apress.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Siva
 *
 */
@ActiveProfiles("test")
@SpringBootTest(classes=SpringbootEssentialsApplication.class)
public class SpringbootEssentialsApplicationTest
{
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Test
	public void testContextLoads()
	{
		System.out.println(dataSourceConfig);
	}

}
