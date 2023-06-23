package com.tcc.petPlusBackEnd.controller;

import java.util.List;
import java.util.Optional;


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

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.UsuarioLogin;
import com.tcc.petPlusBackEnd.service.ClienteService;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService usuarioService;
	
	@Autowired
	private ClienteRepository repositorio;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> Post(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarCliente(cliente));
	}
	
	@PutMapping
	public  ResponseEntity<Cliente> put(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(cliente));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repositorio.deleteById(id);
	}
	
}
