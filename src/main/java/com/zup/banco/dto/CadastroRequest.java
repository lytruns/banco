package com.zup.banco.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.zup.banco.domain.Cadastro;

public class CadastroRequest {

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

	public Cadastro toModel() {
		return new Cadastro(this.nome, this.email, this.cpf, this.dataNascimento);
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
	
	
}
