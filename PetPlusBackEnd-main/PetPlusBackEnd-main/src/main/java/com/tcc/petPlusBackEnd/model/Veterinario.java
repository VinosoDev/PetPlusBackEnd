package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVeterinario;

	@Size(min = 3, max = 50)
	private String nome;

	@NotNull
	private String cpf;

	private String rg;

	@NotNull
	@Email(message = "O atributo Usuario deve ser um email válido")
	private String email;

	@NotNull
	@Size(min = 5)
	private String senha;

	private String telefone;

	@Column(name = "logradouro")
	private String logradouro;

	private int numero;

	private String tipo;

	@Size(max = 5000, message = "The picture link can't be bigger than 5000 chars")
	private String imagem;

	private String bairro;

	private String cidade;

	private String uf;
	
	private int crmv;

	@OneToMany(mappedBy = "veterinario", cascade = javax.persistence.CascadeType.REMOVE)
	@JsonIgnoreProperties({ "veterinario" })
	private List<Clinica> clinicaVeterinario;

	public long getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(long idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getCrmv() {
		return crmv;
	}

	public void setCrmv(int crmv) {
		this.crmv = crmv;
	}

	public List<Clinica> getClinicaVeterinario() {
		return clinicaVeterinario;
	}

	public void setClinicaVeterinario(List<Clinica> clinicaVeterinario) {
		this.clinicaVeterinario = clinicaVeterinario;
	}

}
