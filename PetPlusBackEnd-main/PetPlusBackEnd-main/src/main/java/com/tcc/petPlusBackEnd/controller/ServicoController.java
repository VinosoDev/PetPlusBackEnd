package com.tcc.petPlusBackEnd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.tcc.petPlusBackEnd.model.Servico;
import com.tcc.petPlusBackEnd.repository.ServicoRepository;

@Controller
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoController {
	@Autowired
	ServicoRepository servicoRepository;

	@GetMapping
	public ResponseEntity<List<Servico>> getAll() {
		return ResponseEntity.ok(servicoRepository.findAll());
	}
	
	@GetMapping("/id/{idServico}")
    public ResponseEntity<Optional<Servico>> getById(@PathVariable Long idServico) {
        return ResponseEntity.ok(servicoRepository.findById(idServico));
    }

	@PostMapping
	public ResponseEntity<Servico> Post(@RequestBody Servico servico) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicoRepository.save(servico));
	}
	
	@PutMapping
	public  ResponseEntity<Servico> put(@RequestBody Servico servico){
		return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.save(servico));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		servicoRepository.deleteById(id);
	}

}
