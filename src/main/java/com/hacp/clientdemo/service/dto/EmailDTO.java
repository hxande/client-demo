package com.hacp.clientdemo.service.dto;

import java.io.Serializable;

import com.hacp.clientdemo.Enum.EmailPrincipal;

public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String dsEmail;

	private EmailPrincipal inMain;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public EmailPrincipal getInMain() {
		return inMain;
	}

	public void setInMain(EmailPrincipal inMain) {
		this.inMain = inMain;
	}
}
