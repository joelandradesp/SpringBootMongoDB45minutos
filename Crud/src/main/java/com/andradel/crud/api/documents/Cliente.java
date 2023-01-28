package com.andradel.crud.api.documents;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Document
public class Cliente {
	
	@Id
	private String id;
	private String nome;
	private String email;
	private String cpf;
	
	public Cliente() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min=3, max=25, message = "Nome Inválido")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "CPF não pode ser vazio")
	@CPF(message = "CPF Inválido")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
//	public Cliente(String name, String email, String cpf) {
//		this.nome = name;
//		this.email = email;
//		this.cpf = cpf;
//	}
}
