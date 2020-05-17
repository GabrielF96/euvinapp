package com.euvin.euvin.business;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.euvin.euvin.models.PontoModel;
import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.PontoRepository;
import com.euvin.euvin.security.UserPrincipal;

@Service
public class Ponto {
	
	@Autowired
	PontoRepository pontoRepository;
	@Autowired
	Usuario usuarioBusiness;
	
	public PontoModel carregaOuCriaPontoDoDia() {
		LocalDate dataDoDia = LocalDate.now();
		User usuarioPonto = usuarioBusiness.getUsuarioLogado();
		PontoModel pontoDoDia = carregarPontoDoDia(dataDoDia, usuarioPonto);
		if(pontoDoDia == null) {
			pontoDoDia = criarPontoDoDia(dataDoDia, usuarioPonto);
		}
		return pontoDoDia;
	}
	
	private PontoModel carregarPontoDoDia(LocalDate dataDoDia, User usuarioPonto) {
		return pontoRepository.findByDataPontoAndUsuarioPonto(dataDoDia, usuarioPonto);
	}

	private PontoModel criarPontoDoDia(LocalDate dataDoDia, User usuarioPonto) {
		PontoModel pontoModelParaInserir = new PontoModel();
		pontoModelParaInserir.setDataPonto(dataDoDia);
		pontoModelParaInserir.setUsuarioPonto(usuarioPonto);
		return pontoRepository.save(pontoModelParaInserir);
	}
	
	public PontoModel cadastrarHorarioPonto() {
		LocalDate dataDoDia = LocalDate.now();
		User usuarioPonto = usuarioBusiness.getUsuarioLogado();
		PontoModel ponto = carregarPontoDoDia(dataDoDia, usuarioPonto);
		LocalTime data = LocalTime.now();
		if(ponto.getEntradaPonto()==null) {
			ponto.setEntradaPonto(Time.valueOf(data));
		}
		else if(ponto.getSaidaAlmoco()==null) {
			ponto.setSaidaAlmoco(Time.valueOf(data));
		}
		else if(ponto.getVoltaAlmoco()==null) {
			ponto.setVoltaAlmoco(Time.valueOf(data));
		}
		else if(ponto.getSaidaPonto()==null) {
			ponto.setSaidaPonto(Time.valueOf(data));
		}
		
		return pontoRepository.save(ponto);
	}
	
}
