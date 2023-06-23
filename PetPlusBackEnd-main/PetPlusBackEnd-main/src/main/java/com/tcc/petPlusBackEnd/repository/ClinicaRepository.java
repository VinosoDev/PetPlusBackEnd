package com.tcc.petPlusBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.petPlusBackEnd.model.Clinica;
import com.tcc.petPlusBackEnd.model.Veterinario;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long>{
	public List<Clinica> findByNome(String nome);
	public List<Clinica> findByLogradouro(String logradouro);
	public List<Clinica> findByVeterinario (Veterinario veterinario);
}
