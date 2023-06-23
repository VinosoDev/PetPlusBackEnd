package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_clinica")
public class Clinica {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idClinica;

    @NotNull
    private String nome;

    @NotNull
    @Email(message = "O atributo Usuario deve ser um email válido")
    private String email;


    @NotNull
    private String telefone;

    @Column(name = "logradouro")
    private String logradouro;

    private int numero;



    @Size(max = 5000, message = "The picture link can't be bigger than 5000 chars")
    private String imagem;


    private String bairro;

    private String cidade;


    private String uf;

    @OneToMany(mappedBy = "clinicaServico", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"clinicaServico"})
    private List<Servico> servicoClinica;

    @ManyToOne
    @JsonIgnoreProperties ({"senha","email","clinicaVeterinario"})
    private Veterinario veterinario;


    @OneToMany(mappedBy = "clinicaAgenda", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"clinicaAgenda"})
    private List<Agenda> agenda;
	  
	public long getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(long idClinica) {
		this.idClinica = idClinica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Servico> getServicoClinica() {
		return servicoClinica;
	}

	public void setServicoClinica(List<Servico> servicoClinica) {
		this.servicoClinica = servicoClinica;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}
	
	
	
}
