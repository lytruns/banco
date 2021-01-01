package com.zup.banco.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.zup.banco.dto.CadastroResponse;

@Entity
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "nome em branco!")
	private String nome;
	@NotBlank(message = "email em branco!")
	@Email(message = "email inválido")
	private String email;
	@NotBlank(message = "cpf em branco!")
	@CPF(message = "CPF inválido")
	private String cpf;
	@NotNull(message = "Data em branco!")
	private LocalDate dataNascimento;

	@Deprecated
	public Cadastro() {

	}

	public Cadastro(String nome, String email, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public CadastroResponse toResponse() {
		return new CadastroResponse(this.id, this.nome);
	}

}
