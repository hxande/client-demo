package com.hacp.clientdemo.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClientDemoTest {

	@Test
	public void test() {
		ClientDemo client1 = new ClientDemo();
		client1.setId(1L);
		client1.setName("teste");
		client1.setAge(1);

		ClientDemo client2 = new ClientDemo();
		client2.setId(1L);
		client2.setName("teste");
		client2.setAge(1);

		assertThat(client1.getId() != null && client1.getName() != null);

		assertThat(client1).isEqualTo(client2);

		client2.setId(2L);
		assertThat(client1).isNotEqualTo(client2);
	}

}
