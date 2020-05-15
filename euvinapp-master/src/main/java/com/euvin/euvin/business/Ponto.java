package com.euvin.euvin.business;

import java.time.LocalDate;

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
	
	public PontoModel getPontoModelDoDia() {
		LocalDate dataDoDia = LocalDate.now();
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User usuarioPonto = userPrincipal.getUser();
		PontoModel pontoDoDia = pontoRepository.findByDataPontoAndUsuarioPonto(dataDoDia, usuarioPonto);
		if(pontoDoDia == null) {
			PontoModel pontoModelParaInserir = new PontoModel();
			pontoModelParaInserir.setDataPonto(dataDoDia);
			pontoModelParaInserir.setUsuarioPonto(usuarioPonto);
			pontoDoDia = pontoRepository.save(pontoModelParaInserir);
		}
		return pontoDoDia;
	}
}
