package com.euvin.euvin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PontoController{

    @RequestMapping("/assinarPonto")
    public String assinarPonto(){
        return "assinarPonto";
    }
}