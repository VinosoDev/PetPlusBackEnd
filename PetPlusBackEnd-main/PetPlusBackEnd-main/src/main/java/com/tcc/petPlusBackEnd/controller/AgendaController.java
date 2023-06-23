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

import com.tcc.petPlusBackEnd.model.Agenda;
import com.tcc.petPlusBackEnd.repository.AgendaRepository;

@Controller
@RequestMapping("/agenda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendaController {
	@Autowired
	AgendaRepository agendaRepository;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> getAll(){
		return ResponseEntity.ok(agendaRepository.findAll());
	}
	
	@PostMapping
    public ResponseEntity<Agenda> post(@RequestBody Agenda agenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaRepository.save(agenda));
    }
	
	@PutMapping
	public ResponseEntity<Agenda> put(@RequestBody Agenda agenda){
		return ResponseEntity.status(HttpStatus.OK).body(agendaRepository.save(agenda));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		agendaRepository.deleteById(id);
	}


}
