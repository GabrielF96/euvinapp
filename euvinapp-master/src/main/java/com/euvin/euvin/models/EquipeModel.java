package com.euvin.euvin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Equipe", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class EquipeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "nome_equipe")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_lider_equipe")
	private User liderEquipe;
	
	@ManyToOne
	@JoinColumn(name="cnpj_empresa")
	private EmpresaModel empresaEquipe;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public User getLiderEquipe() {
		return liderEquipe;
	}

	public void setLiderEquipe(User liderEquipe) {
		this.liderEquipe = liderEquipe;
	}

	public EmpresaModel getEmpresaEquipe() {
		return empresaEquipe;
	}

	public void setEmpresaEquipe(EmpresaModel empresaEquipe) {
		this.empresaEquipe = empresaEquipe;
	}

}
