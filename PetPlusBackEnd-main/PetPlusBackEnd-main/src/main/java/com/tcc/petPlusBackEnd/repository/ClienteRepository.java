package com.tcc.petPlusBackEnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Optional<Cliente> findByEmail(String email);
	public Optional<Cliente> findByIdClient(Long idClient);

}
