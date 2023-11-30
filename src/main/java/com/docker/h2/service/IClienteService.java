package com.docker.h2.service;

import java.util.List;

import com.docker.h2.entities.Cliente;

public interface IClienteService {

	public Cliente save(Cliente cliente);
	
	public List<Cliente> findAll();
	
	
}
