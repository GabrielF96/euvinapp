package com.euvin.euvin.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euvin.euvin.models.EmpresaModel;
import com.euvin.euvin.repository.EmpresaRepository;

@Service
public class Empresa {
	
	 @Autowired
	 EmpresaRepository equipeRepository;
	
	public List<EmpresaModel> getEmpresas(){
		List<EmpresaModel> empresasList = new ArrayList<EmpresaModel>();
		
		empresasList.addAll(equipeRepository.findAll());
		
		return empresasList;
	}
	
	public void cadastrarEmpresa(EmpresaModel empresaModel) {
		equipeRepository.save(empresaModel);
	}
}