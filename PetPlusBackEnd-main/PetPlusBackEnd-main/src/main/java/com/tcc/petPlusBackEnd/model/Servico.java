package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_servico")
public class Servico {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idServico;

    @NotNull
    String tipoServico;

    @NotNull
    Double valor;

    @ManyToOne
    @JsonIgnoreProperties({"servicoClinica","veterinario"})
    private Clinica clinicaServico;

	public long getIdServico() {
		return idServico;
	}

	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Clinica getClinicaServico() {
		return clinicaServico;
	}

	public void setClinicaServico(Clinica clinicaServico) {
		this.clinicaServico = clinicaServico;
	}
	
	
}
