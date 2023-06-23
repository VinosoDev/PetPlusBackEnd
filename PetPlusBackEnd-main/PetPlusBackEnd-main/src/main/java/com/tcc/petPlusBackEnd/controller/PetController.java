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

import com.tcc.petPlusBackEnd.model.Pet;
import com.tcc.petPlusBackEnd.repository.PetRepository;

@Controller
@RequestMapping("/pet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {
	@Autowired
	PetRepository petRepository;
	
	@GetMapping
	public ResponseEntity<List<Pet>> getAll(){
		return ResponseEntity.ok(petRepository.findAll());
	}
	
	@PostMapping
    public ResponseEntity<Pet> Post(@RequestBody Pet pet){
        return ResponseEntity.status(HttpStatus.CREATED).body(petRepository.save(pet));
	}
	
	@PutMapping
	public  ResponseEntity<Pet> put(@RequestBody Pet pet){
		return ResponseEntity.status(HttpStatus.OK).body(petRepository.save(pet));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		petRepository.deleteById(id);
	}

}
