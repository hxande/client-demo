package com.hacp.clientdemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacp.clientdemo.model.ClientDemo;

@Repository
public interface ClientDemoRepository extends JpaRepository<ClientDemo, Long> {
	
	Page<ClientDemo> findByAge(Integer age, Pageable pageable);

	Page<ClientDemo> findByNameContaining(String name, Pageable pageable);
	
	Page<ClientDemo> findByAgeAndNameContaining(Integer age, String name, Pageable pageable);


}
