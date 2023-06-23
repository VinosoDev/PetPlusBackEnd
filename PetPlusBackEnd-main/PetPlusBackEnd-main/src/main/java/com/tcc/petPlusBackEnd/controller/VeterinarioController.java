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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.UsuarioLogin;
import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.model.VeterinarioLogin;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;
import com.tcc.petPlusBackEnd.service.VeterinarioService;

@Controller
@RequestMapping("/veterinario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeterinarioController {
	@Autowired
	private VeterinarioRepository vetRepository;
	
	@Autowired
	private VeterinarioService vetService;

	@GetMapping
	public ResponseEntity<List<Veterinario>> getAll() {
		return ResponseEntity.ok(vetRepository.findAll());
	}
	
	@GetMapping("/id/{idVeterinario}")
    public ResponseEntity<Optional<Veterinario>> getById(@PathVariable Long idVeterinario) {
        return ResponseEntity.ok(vetRepository.findById(idVeterinario));
    }
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Veterinario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(vetRepository.findByNome(nome));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Veterinario> Post(@RequestBody Veterinario veterinario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(vetService.cadastrarVeterinario(veterinario));
		
	}
	
	@PutMapping
    public  ResponseEntity<Veterinario> put(@RequestBody Veterinario veterinario){

        return vetService.atualizarVeterinario(veterinario)
                .map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		vetRepository.deleteById(id);
	}

}
