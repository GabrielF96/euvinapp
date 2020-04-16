package com.euvin.euvin.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.euvin.euvin.security.UserPrincipal;

@Controller
@RequestMapping("/")
public class IndexController{
	
    @GetMapping("home")
    public String index(){
    	UserPrincipal usuarioLogado = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println(usuarioLogado.getUser().isPrimeiroAcesso());
        return "index";
    }

    @GetMapping("login")
        public String login(){
        return "login";
    }
}