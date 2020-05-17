package com.euvin.euvin.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "Ponto", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class PontoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "data_ponto")
	private LocalDate dataPonto;
	
	@Column(name = "entrada_ponto")
	private Time entradaPonto;
	
	@Column(name = "saida_almoco")
	private Time saidaAlmoco;
	
	@Column(name = "volta_almoco")
	private Time voltaAlmoco;
	
	@Column(name = "saida_ponto")
	private Time saidaPonto;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private User usuarioPonto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUsuarioPonto() {
		return usuarioPonto;
	}

	public void setUsuarioPonto(User usuarioPonto) {
		this.usuarioPonto = usuarioPonto;
	}

	public LocalDate getDataPonto() {
		return dataPonto;
	}

	public void setDataPonto(LocalDate dataPonto) {
		this.dataPonto = dataPonto;
	}

	public Time getEntradaPonto() {
		return entradaPonto;
	}

	public void setEntradaPonto(Time entradaPonto) {
		this.entradaPonto = entradaPonto;
	}

	public Time getSaidaAlmoco() {
		return saidaAlmoco;
	}

	public void setSaidaAlmoco(Time saidaAlmoco) {
		this.saidaAlmoco = saidaAlmoco;
	}

	public Time getVoltaAlmoco() {
		return voltaAlmoco;
	}

	public void setVoltaAlmoco(Time voltaAlmoco) {
		this.voltaAlmoco = voltaAlmoco;
	}

	public Time getSaidaPonto() {
		return saidaPonto;
	}

	public void setSaidaPonto(Time saidaPonto) {
		this.saidaPonto = saidaPonto;
	}

}
