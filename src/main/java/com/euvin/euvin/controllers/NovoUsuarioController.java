package com.euvin.euvin.controllers;

import java.util.UUID;

import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarUsuario")
public class NovoUsuarioController{

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository ur;

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
        user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString()));
        user.setPermissions("");
        ur.save(user);

        return "redirect:/cadastrarUsuario";
    }
}