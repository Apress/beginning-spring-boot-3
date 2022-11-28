package com.apress.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Siva
 *
 */

@SpringBootApplication
public class SpringbootEssentialsApplication implements CommandLineRunner
{
	private final DataSourceConfig dataSourceConfig;

	public SpringbootEssentialsApplication(DataSourceConfig dataSourceConfig) {
		this.dataSourceConfig = dataSourceConfig;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootEssentialsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.err.println(dataSourceConfig);
	}
}
