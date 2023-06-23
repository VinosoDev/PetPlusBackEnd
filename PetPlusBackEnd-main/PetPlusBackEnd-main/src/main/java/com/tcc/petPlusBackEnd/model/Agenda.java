package com.tcc.petPlusBackEnd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_agenda")
public class Agenda {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAgenda;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario  = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JsonIgnoreProperties({"email","senha","agenda"})
    private Cliente clienteAgenda;

    @ManyToOne
    @JsonIgnoreProperties({"agenda"})
    private Clinica clinicaAgenda;

    private Long petID;

    private Long servicoID;
	
	public long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Cliente getClienteAgenda() {
		return clienteAgenda;
	}

	public void setClienteAgenda(Cliente clienteAgenda) {
		this.clienteAgenda = clienteAgenda;
	}

	public Clinica getClinicaAgenda() {
		return clinicaAgenda;
	}

	public void setClinicaAgenda(Clinica clinicaAgenda) {
		this.clinicaAgenda = clinicaAgenda;
	}

	public long getPetID() {
		return petID;
	}

	public void setPetID(long petID) {
		this.petID = petID;
	}

	public long getServicoID() {
		return servicoID;
	}

	public void setServicoID(long servicoID) {
		this.servicoID = servicoID;
	}

	public void setPetID(Long petID) {
		this.petID = petID;
	}

	public void setServicoID(Long servicoID) {
		this.servicoID = servicoID;
	}
	
	
	
}
