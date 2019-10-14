package com.euvin.euvin.controllers;

import javax.transaction.Transactional;

import com.euvin.euvin.models.PasswordResetDto;
import com.euvin.euvin.models.PasswordResetToken;
import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.PasswordResetTokenRepository;
import com.euvin.euvin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reset-password")
public class ResetPasswordController{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordResetTokenRepository prTokenRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute("passwordResetForm")
    public PasswordResetDto passwordReset() {
        return new PasswordResetDto();
    }

    @GetMapping
    public String resetPasswordPage(@RequestParam(required = false) String token, Model model){
        PasswordResetToken prToken = prTokenRepository.findByToken(token);
        model.addAttribute("token", prToken.getToken());
        
        return "resetPassword";
    }

    @PostMapping
    @Transactional
    public String resetPasswordChange(@ModelAttribute("passwordResetForm") PasswordResetDto prDto){
        PasswordResetToken psResetToken = prTokenRepository.findByToken(prDto.getToken());
        User user = psResetToken.getUser();
        userRepository.updatePassword(passwordEncoder.encode(prDto.getNewPassword()), user.getId());
        
        return "redirect:/login";
    }
}