package com.euvin.euvin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.euvin.euvin.business.Usuario;
import com.euvin.euvin.models.User;

@Controller
@RequestMapping("/cadastrarUsuario")
public class NovoUsuarioController{
	
	@Autowired
	Usuario usuario;

    @ModelAttribute("cadastrarUsuarioForm")
    public User passwordReset() {
        return new User();
    }

    @GetMapping
    public String cadastrarUsuarioPage(){
        return "cadastrarFuncionario";
    }

    @PostMapping
    public String cadastrarUsuarioSave(@ModelAttribute("cadastrarUsuarioForm") User user){
    	usuario.cadastraUsuario(user);

        return "redirect:/cadastrarUsuario";
    }
}