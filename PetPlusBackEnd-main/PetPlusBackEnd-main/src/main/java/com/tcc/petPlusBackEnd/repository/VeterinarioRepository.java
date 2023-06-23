package com.tcc.petPlusBackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.petPlusBackEnd.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
	public List<Veterinario> findByNome (String nome);
	public Optional<Veterinario> findOneByEmail (String email);
}
