package com.tcc.petPlusBackEnd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	public List<Transacao> findByClienteIdAndData(Long clienteId, Date data);
}

