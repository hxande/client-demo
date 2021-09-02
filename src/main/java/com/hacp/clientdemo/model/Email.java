package com.hacp.clientdemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hacp.clientdemo.Enum.EmailPrincipal;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_email", schema = "public")
public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id")
	private Long id;

	@ApiModelProperty(notes = "Description of email", name = "dsEmail")
	@NotNull
	@Column(name = "email_desc")
	private String dsEmail;

	@ApiModelProperty(notes = "Indicator of main email", name = "inMain")
	@Enumerated(EnumType.STRING)
	@Column(name = "email_in")
	private EmailPrincipal inMain;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_demo_id")
	private ClientDemo clientDemo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public ClientDemo getClientDemo() {
		return clientDemo;
	}

	public void setClientDemo(ClientDemo clientDemo) {
		this.clientDemo = clientDemo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
