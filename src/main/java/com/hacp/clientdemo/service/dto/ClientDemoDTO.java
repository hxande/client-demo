package com.hacp.clientdemo.service.dto;

import java.io.Serializable;
import java.util.List;

public class ClientDemoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;

	private int age;

	private List<EmailDTO> emails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}
}
