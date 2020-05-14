package com.euvin.euvin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Ponto", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class PontoModel {
	
	@Id
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "data_ponto")
	private String dataPonto;
	
	@Column(name = "entrada_ponto")
	private String entradaPonto;
	
	@Column(name = "saida_almoco")
	private String saidaAlmoco;
	
	@Column(name = "volta_almoco")
	private String voltaAlmoco;
	
	@Column(name = "saida_ponto")
	private String saidaPonto;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private User usuarioPonto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataPonto() {
		return dataPonto;
	}

	public void setDataPonto(String dataPonto) {
		this.dataPonto = dataPonto;
	}

	public String getEntradaPonto() {
		return entradaPonto;
	}

	public void setEntradaPonto(String entradaPonto) {
		this.entradaPonto = entradaPonto;
	}

	public String getSaidaAlmoco() {
		return saidaAlmoco;
	}

	public void setSaidaAlmoco(String saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	public String getVoltaAlmoco() {
		return voltaAlmoco;
	}

	public void setVoltaAlmoco(String voltaAlmoco) {
		this.voltaAlmoco = voltaAlmoco;
	}

	public String getSaidaPonto() {
		return saidaPonto;
	}

	public void setSaidaPonto(String saidaPonto) {
		this.saidaPonto = saidaPonto;
	}

	public User getUsuarioPonto() {
		return usuarioPonto;
	}

	public void setUsuarioPonto(User usuarioPonto) {
		this.usuarioPonto = usuarioPonto;
	}
	
}
