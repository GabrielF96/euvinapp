package com.euvin.euvin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Empresa", uniqueConstraints = @UniqueConstraint(columnNames = "cnpj_empresa"))
public class EmpresaModel {
	
	@Id
	@Column(name="cnpj_empresa", nullable = false)
	private String cnpjEmpresa;
	
	@Column(name="razao_social_empresa")
	private String razaoSocial;
	
	@Column(name="nome_fantasia_empresa")
	private String nomeFantasia;
	
	@Column(name="endereco_empresa")
	private String endereco;
	
	@Column(name="contato_empresa")
	private String contato;

	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	
}
