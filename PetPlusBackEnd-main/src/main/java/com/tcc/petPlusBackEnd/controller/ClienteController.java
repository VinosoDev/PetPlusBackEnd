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
import com.tcc.petPlusBackEnd.model.Transacao;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;
import com.tcc.petPlusBackEnd.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }

    @PostMapping("/{clienteId}/saque")
    public Cliente sacarValor(@PathVariable Long clienteId, @RequestParam BigDecimal valor) {
        return clienteService.sacarValor(clienteId, valor);
    }

    @PostMapping("/{clienteId}/deposito")
    public Cliente depositarValor(@PathVariable Long clienteId, @RequestParam BigDecimal valor) {
        return clienteService.depositarValor(clienteId, valor);
    }

    @GetMapping("/{clienteId}/transacoes")
    public List<Transacao> consultarHistoricoTransacoes(@PathVariable Long clienteId, @RequestParam Date data) {
        return clienteService.consultarHistoricoTransacoes(clienteId, data);
    }
}

