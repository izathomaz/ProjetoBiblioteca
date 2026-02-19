package com.projetoBiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String razaoFiscal;
	@Column
	private String nomeFantasia;
	@Column
	private String cnpj;
	@Column
	private String endereco;
	@Column
	private String fone;
	@Column
	private String email;
	@Column
	private String inscricaoEstadual;
	
	public Fornecedor() {
	}

	public Fornecedor(Long id, String razaoFiscal, String nomeFantasia, String cnpj, String endereco, String fone, String email, String inscricaoEstadual) {
		this.id = id;
		this.razaoFiscal = razaoFiscal;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.fone = fone;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoFiscal() {
		return razaoFiscal;
	}

	public void setRazaoFiscal(String razaoFiscal) {
		this.razaoFiscal = razaoFiscal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
}
