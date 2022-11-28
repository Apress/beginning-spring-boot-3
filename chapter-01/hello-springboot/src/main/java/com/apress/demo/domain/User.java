package com.apress.demo.domain;

import jakarta.persistence.*;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "users")
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	
	public User()
	{
	}

	public User(Integer id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
