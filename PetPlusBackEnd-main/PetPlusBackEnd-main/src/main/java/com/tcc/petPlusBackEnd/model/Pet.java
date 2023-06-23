package com.tcc.petPlusBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_pet")
public class Pet {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idPet;

    @NotNull
    @Size(min = 2, max = 30)
    String nome;

    @NotNull
    int idade;

    @NotNull
    String especie;

    @NotNull
    String porte;

    @NotNull
    String raca;

    @ManyToOne
    @JsonIgnoreProperties({"senha", "email", "pet"})
    private Cliente clientePet;

	public long getIdPet() {
		return idPet;
	}

	public void setIdPet(long idPet) {
		this.idPet = idPet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Cliente getClientePet() {
		return clientePet;
	}

	public void setClientePet(Cliente clientePet) {
		this.clientePet = clientePet;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	
	
	
	
}
