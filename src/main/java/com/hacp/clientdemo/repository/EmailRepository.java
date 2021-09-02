package com.hacp.clientdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacp.clientdemo.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
