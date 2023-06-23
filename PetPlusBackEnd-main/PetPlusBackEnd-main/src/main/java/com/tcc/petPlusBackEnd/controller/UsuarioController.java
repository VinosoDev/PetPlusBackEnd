package com.tcc.petPlusBackEnd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.petPlusBackEnd.model.UsuarioLogin;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;
import com.tcc.petPlusBackEnd.service.ClienteService;
import com.tcc.petPlusBackEnd.service.VeterinarioService;

@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Autowired
	private VeterinarioService vetService;
	
	@Autowired
	private VeterinarioRepository vetRepositorio;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		if(user.get().getTipo().equalsIgnoreCase("cliente")) {
			return clienteService.Logar(user).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}else if(user.get().getTipo().equalsIgnoreCase("veterinario")) {
			return vetService.Logar(user).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}

		
	}
}
