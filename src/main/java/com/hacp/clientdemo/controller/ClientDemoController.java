package com.hacp.clientdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hacp.clientdemo.model.ClientDemo;
import com.hacp.clientdemo.service.ClientDemoService;
import com.hacp.clientdemo.service.dto.ClientDemoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Client Controller")
@RestController
public class ClientDemoController {
	
	@Autowired
	private ClientDemoService clientDemoService;

	@ApiOperation(value = "List of clients", response = Iterable.class, tags = "CLIENT")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!"),
			@ApiResponse(code = 404, message = "not found!") })
	@GetMapping(value = "/clients")
	public ResponseEntity<List<ClientDemo>> getAllClients(
	        @RequestParam(required = false) String name,
	        @RequestParam(required = false) String age,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size) {
		try {
			Pageable paging = PageRequest.of(page, size);
			Page<ClientDemo> clients;

			if (name == null && age == null) {
				clients = clientDemoService.findAll(paging);
			} else if (name == null && age != null) {
				clients = clientDemoService.findByAge(Integer.valueOf(age), paging);
			} else if (name != null && age == null) {
				clients = clientDemoService.findByNameContaining(name, paging);
			} else {
				clients = clientDemoService.findByAgeAndNameContaining(Integer.valueOf(age), name, paging);
			}

			return ResponseEntity.ok().body(clients.getContent());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Client found", response = ClientDemo.class, tags = "CLIENT")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!"),
			@ApiResponse(code = 404, message = "not found!") })
	@GetMapping(value = "/clients/{id}")
	public ResponseEntity<Optional<ClientDemo>> getClient(@PathVariable Long id) {
		return ResponseEntity.ok().body(clientDemoService.findOne(id));
	}
	
	@ApiOperation(value = "Client created", response = ClientDemo.class, tags = "CLIENT")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!"),
			@ApiResponse(code = 404, message = "not found!") })
	@PostMapping(value = "/clients")
	public ResponseEntity<ClientDemo> createClient(@RequestBody ClientDemoDTO dto) throws Exception {
		if (dto.getId() != 0) {
            throw new Exception("Cannot have an id");
        }

		ClientDemo result = clientDemoService.save(dto);
		return ResponseEntity.ok().body(result);
	}
	
	@ApiOperation(value = "Client updated", response = ClientDemo.class, tags = "CLIENT")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "success|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!"),
			@ApiResponse(code = 404, message = "not found!") })
	@PutMapping(value = "/clients")
	public ResponseEntity<ClientDemo> updateClient(@RequestBody ClientDemoDTO dto) throws Exception {
		if (dto.getId() == 0) {
            throw new Exception("Invalid id");
        }

		ClientDemo result = clientDemoService.save(dto);
		return ResponseEntity.ok().body(result);
	}

}
