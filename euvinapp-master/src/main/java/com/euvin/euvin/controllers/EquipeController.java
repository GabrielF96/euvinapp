package com.euvin.euvin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.euvin.euvin.business.Empresa;
import com.euvin.euvin.business.Equipe;
import com.euvin.euvin.business.Usuario;
import com.euvin.euvin.models.EquipeModel;

@Controller
@RequestMapping("/cadastrarEquipe")
public class EquipeController {
	
	@Autowired
	Usuario usuario;
	@Autowired
	Empresa empresa;
	@Autowired
	Equipe equipe;
	
	@ModelAttribute("cadastrarEquipeForm")
	public EquipeModel equipeModelForm() {
		return new EquipeModel();
	}
	
	@GetMapping
	public ModelAndView cadastrarEquipePage() {
		ModelAndView mv = new ModelAndView("cadastroEquipe");
		mv.addObject("usuariosLiderList", usuario.getUsuariosRole("LIDER"));
		mv.addObject("empresasList", empresa.getEmpresas());
		
		return mv;
	}
	
	@PostMapping
	public String cadastrarEquipeSave(@ModelAttribute("cadastrarEquipeForm") EquipeModel equipeModel) {
		
		equipe.cadastrarEquipe(equipeModel);
		
		return "index";
	}
}
