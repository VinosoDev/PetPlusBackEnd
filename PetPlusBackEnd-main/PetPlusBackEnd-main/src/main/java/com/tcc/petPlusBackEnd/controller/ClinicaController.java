package com.tcc.petPlusBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.petPlusBackEnd.model.Clinica;
import com.tcc.petPlusBackEnd.model.Servico;
import com.tcc.petPlusBackEnd.repository.ClinicaRepository;
import com.tcc.petPlusBackEnd.repository.ServicoRepository;

@Controller
@RequestMapping("/clinica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClinicaController {
	@Autowired
	ClinicaRepository clinicaRepository;

	@Autowired
	ServicoRepository servicoRepository;

	@GetMapping
	public ResponseEntity<List<Clinica>> getAll() {
		return ResponseEntity.ok(clinicaRepository.findAll());
	}

	@GetMapping("/{nome}")
	public ResponseEntity<List<Clinica>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(clinicaRepository.findByNome(nome));
	}

	@GetMapping("/endereco/{logradouro}")
	public ResponseEntity<List<Clinica>> getByLogradouro(@PathVariable String logradouro) {
		return ResponseEntity.ok(clinicaRepository.findByLogradouro(logradouro));
	}
	
	@GetMapping("/id/{idClinica}")
    public ResponseEntity<Clinica> getById(@PathVariable Long idClinica) {
        return clinicaRepository.findById(idClinica).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

	@PostMapping
	public ResponseEntity<Clinica> Post(@RequestBody Clinica clinica) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clinicaRepository.save(clinica));
	}

	@PutMapping
	public ResponseEntity<Clinica> put(@RequestBody Clinica clinica) {
		return ResponseEntity.status(HttpStatus.OK).body(clinicaRepository.save(clinica));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		clinicaRepository.deleteById(id);
	}
}
