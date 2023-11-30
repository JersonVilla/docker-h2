package com.docker.h2.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docker.h2.entities.Cliente;
import com.docker.h2.repository.IClienteRepository;
import com.docker.h2.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	private IClienteRepository clienteRepository;
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
