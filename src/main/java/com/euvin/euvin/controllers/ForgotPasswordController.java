package com.euvin.euvin.controllers;

import java.util.UUID;

import com.euvin.euvin.models.PasswordResetToken;
import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.PasswordResetTokenRepository;
import com.euvin.euvin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class ForgotPasswordController{
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordResetTokenRepository prTokenRepository;
    @Autowired
    private MailSender mailSender;
    
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassForm(){
        return "forgotPassForm";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String forgotPassForm(String email) throws NotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new NotFoundException("Email não encontrado!");
        }

        PasswordResetToken prToken = new PasswordResetToken();
        prToken.setToken(UUID.randomUUID().toString());
        prToken.setUser(user);
        prToken.setExpirationDate(30);
        prTokenRepository.save(prToken);

        SimpleMailMessage msgEmail = new SimpleMailMessage();
        msgEmail.setSubject("Recuperação de Senha");
        msgEmail.setTo(user.getEmail());
        msgEmail.setText("Acesse o link para resetar sua senha:"+ 
                        "http://localhost:8080/reset-password?token=" + prToken.getToken());
        mailSender.send(msgEmail);

        return "redirect:/login";
    }
}