package com.euvin.euvin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionariosController{

    @RequestMapping("/gerirFuncionarios")
    public String gerirFuncionarios(){
        return "gerirFuncionarios";
    }
}