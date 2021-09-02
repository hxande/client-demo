package com.hacp.clientdemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hacp.clientdemo.model.ClientDemo;
import com.hacp.clientdemo.model.Email;
import com.hacp.clientdemo.repository.ClientDemoRepository;
import com.hacp.clientdemo.repository.EmailRepository;
import com.hacp.clientdemo.service.dto.ClientDemoDTO;
import com.hacp.clientdemo.service.dto.EmailDTO;

@Service
@Transactional
public class ClientDemoService {

	@Autowired
	private ClientDemoRepository clientDemoRepository;
	
	@Autowired
	private EmailRepository emailRepository;

	@Transactional
	public Optional<ClientDemo> findOne(Long id) {
		return clientDemoRepository.findById(id);
	}

	@Transactional
	public Page<ClientDemo> findAll(Pageable pageable) {
		return clientDemoRepository.findAll(pageable);
	}

	@Transactional
	public Page<ClientDemo> findByAge(Integer age, Pageable pageable) {
		return clientDemoRepository.findByAge(age, pageable);
	}
	
	@Transactional
	public Page<ClientDemo> findByNameContaining(String name, Pageable pageable) {
		return clientDemoRepository.findByNameContaining(name, pageable);
	}
	
	@Transactional
	public Page<ClientDemo> findByAgeAndNameContaining(Integer age, String name, Pageable pageable) {
		return clientDemoRepository.findByAgeAndNameContaining(age, name, pageable);
	}
	
	@Transactional
	public ClientDemo save(ClientDemoDTO clientDemoDTO) {
		ClientDemo clientDemo = new ClientDemo();
		if (clientDemoDTO.getId() != 0) {
			clientDemo.setId(clientDemoDTO.getId());			
		}
		clientDemo.setName(clientDemoDTO.getName());
		clientDemo.setAge(clientDemoDTO.getAge());

		clientDemo = clientDemoRepository.save(clientDemo);
		
		for (EmailDTO clientEmail : clientDemoDTO.getEmails()) {
			Email email = new Email();
			if (clientEmail.getId() != 0) {
				email.setId(clientEmail.getId());			
			}
			email.setInMain(clientEmail.getInMain());
			email.setDsEmail(clientEmail.getDsEmail());
			email.setClientDemo(clientDemo);
			emailRepository.save(email);
		}

		return clientDemo;
	}

	@Transactional
	public void delete(Long id) {
		clientDemoRepository.deleteById(id);
	}

}
