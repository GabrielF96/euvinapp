package com.euvin.euvin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "lider_equipe")
	private long codigoLider;
	
	@Column(name = "cnpj_empresa")
	private String cnpjEmpresa;

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

	public long getCodigoLider() {
		return codigoLider;
	}

	public void setCodigoLider(long codigoLider) {
		this.codigoLider = codigoLider;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
}
