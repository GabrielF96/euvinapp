package com.euvin.euvin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.euvin.euvin.business.Usuario;
import com.euvin.euvin.models.User;

@Controller
@RequestMapping("/cadastrarEquipe")
public class EquipeController {
	
	@Autowired
	Usuario usuario;
	
	@GetMapping
	public ModelAndView cadastrarEquipePage() {
		ModelAndView mv = new ModelAndView("cadastroEquipe");
		mv.addObject("usuariosLiderList", usuario.getUsuariosRole("LIDER"));
		
		return mv;
	}
}
