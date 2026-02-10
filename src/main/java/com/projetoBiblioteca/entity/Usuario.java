package com.projetoBiblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private int password;
	@Column
	private String permissao;
	@Column
	private String tipoUsuario;

	public Usuario() {
	}

	public Usuario(Long id, String nome, int password, String permissao, String tipoUsuario) {
		this.id = id;
		this.nome = nome;
		this.password = password;
		this.permissao = permissao;
		this.tipoUsuario = tipoUsuario;
	}
}