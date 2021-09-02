package com.hacp.clientdemo.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.hacp.clientdemo.Enum.EmailPrincipal;

@RunWith(SpringRunner.class)
public class EmailTest {

	@Test
	public void test() {
		Email email1 = new Email();
		email1.setId(1L);
		email1.setDsEmail("teste@gmail.com");
		email1.setInMain(EmailPrincipal.S);
		email1.setClientDemo(new ClientDemo());

		Email email2 = new Email();
		email2.setId(1L);
		email2.setDsEmail("teste@gmail.com");
		email2.setInMain(EmailPrincipal.S);
		email2.setClientDemo(new ClientDemo());

		assertThat(email1.getId() != null && 
				email1.getDsEmail() != null && 
				email1.getInMain() != null && 
				email1.getClientDemo() != null);

		assertThat(email1).isEqualTo(email2);

		email2.setId(2L);
		assertThat(email1).isNotEqualTo(email2);
	}

}
