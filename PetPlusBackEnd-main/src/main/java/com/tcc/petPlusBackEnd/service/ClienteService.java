package com.tcc.petPlusBackEnd.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.Transacao;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;
import com.tcc.petPlusBackEnd.repository.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Transacao saveTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }


    public Cliente sacarValor(Long clienteId, BigDecimal valor) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        BigDecimal saldoAtual = cliente.getSaldo();
        BigDecimal taxa = calcularTaxaSaque(valor, cliente.isPlanoExclusive());

        if (saldoAtual.compareTo(valor.add(taxa)) >= 0) {
            BigDecimal novoSaldo = saldoAtual.subtract(valor).subtract(taxa);
            cliente.setSaldo(novoSaldo);
            
            Transacao transacao = new Transacao();
            transacao.setValor(valor);
            transacao.setTipo("Saque");
            transacao.setData(new Date());
            transacao.setCliente(cliente);
            transacaoRepository.save(transacao);
            
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
    }

    private BigDecimal calcularTaxaSaque(BigDecimal valor, boolean isPlanoExclusive) {
        if (valor.compareTo(BigDecimal.valueOf(100)) <= 0) {
            return BigDecimal.ZERO; // Isento de taxa de saque
        } else if (valor.compareTo(BigDecimal.valueOf(300)) <= 0 || isPlanoExclusive) {
            return valor.multiply(BigDecimal.valueOf(0.004)); // Taxa de 0.4%
        } else {
            return valor.multiply(BigDecimal.valueOf(0.01)); // Taxa de 1%
        }
    }


    public Cliente depositarValor(Long clienteId, BigDecimal valor) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        BigDecimal novoSaldo = cliente.getSaldo().add(valor);
        cliente.setSaldo(novoSaldo);
        
        Transacao transacao = new Transacao();
        transacao.setValor(valor);
        transacao.setTipo("Depósito");
        transacao.setData(new Date());
        transacao.setCliente(cliente);
        transacaoRepository.save(transacao);

        return clienteRepository.save(cliente);
    }


    public List<Transacao> consultarHistoricoTransacoes(Long clienteId, Date data) {
        return transacaoRepository.findByClienteIdAndData(clienteId, data);
    }
}

