package com.euvin.euvin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.euvin.euvin.business.Ponto;
import com.euvin.euvin.models.PontoModel;

@Controller
@RequestMapping("/assinarPonto")
public class PontoController{
	
	@Autowired
	Ponto ponto;

	@ModelAttribute("cadastrarPontoForm")
	public PontoModel pontoModelForm() {
		return new PontoModel();
	}
	
    @GetMapping
    public ModelAndView assinarPonto(){
        
    	ModelAndView mv = new ModelAndView("controlePonto");
    	mv.addObject("ponto", ponto.getPontoModelDoDia());
    	
    	return mv;
    }
    
    @PostMapping
    public String salvarRegistroPonto() {
    	ponto.getPontoModelDoDia();
    	return "redirect:/home";
    }
    
}