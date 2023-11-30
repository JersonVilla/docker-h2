package com.docker.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docker.h2.entities.Cliente;
import com.docker.h2.serviceImpl.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllTutorials() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clientes = clienteServiceImpl.findAll();

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> createTutorial(@RequestBody Cliente cliente) {
		try {
			Cliente _cliente = clienteServiceImpl.save(new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getEdad()));
			return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
