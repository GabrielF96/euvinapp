package com.euvin.euvin.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euvin.euvin.models.EquipeModel;
import com.euvin.euvin.repository.EquipeRepository;

@Service
public class Equipe {
	
	@Autowired
	EquipeRepository equipeRepository;
	
	public void cadastrarEquipe(EquipeModel equipeModel) {
		equipeRepository.save(equipeModel);
	}
}
