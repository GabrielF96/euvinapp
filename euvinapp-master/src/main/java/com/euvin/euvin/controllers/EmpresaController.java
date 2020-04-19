package com.euvin.euvin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.euvin.euvin.business.Empresa;
import com.euvin.euvin.models.EmpresaModel;

@Controller
@RequestMapping("/cadastrarEmpresa")
public class EmpresaController {
	
	@Autowired
	Empresa empresa;
	
	@ModelAttribute("cadastrarEmpresaForm")
	public EmpresaModel empresaModelForm() {
		return new EmpresaModel();
	}
	
	@GetMapping
	public ModelAndView cadastrarEmpresaPage() {
		ModelAndView mv = new ModelAndView("cadastroEmpresa");
		
		return mv;
	}
	
	@PostMapping
	public String cadastrarEmpresaSave(@ModelAttribute("cadastrarEmpresaForm") EmpresaModel empresaModel) {
		empresa.cadastrarEmpresa(empresaModel);
		
		return "redirect:/home";
	}
}
