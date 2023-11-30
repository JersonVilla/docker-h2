package com.docker.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.h2.entities.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

}
