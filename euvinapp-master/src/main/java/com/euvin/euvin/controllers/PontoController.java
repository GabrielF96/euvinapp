package com.euvin.euvin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.euvin.euvin.models.PontoModel;

@Controller
public class PontoController{

	@ModelAttribute("cadastrarPontoForm")
	public PontoModel pontoModelForm() {
		return new PontoModel();
	}
	
    @RequestMapping("/assinarPonto")
    public ModelAndView assinarPonto(){
        
    	ModelAndView mv = new ModelAndView("cadastroPonto");
    	
    	return mv;
    }
    
    
}