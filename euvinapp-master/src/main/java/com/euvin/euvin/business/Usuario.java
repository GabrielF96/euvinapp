package com.euvin.euvin.business;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.UserRepository;

@Service
public class Usuario {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository ur;
    @Autowired
	MailSender mailSender;
    
	public void cadastraUsuario(User user) {
		user.setPasswordAnterior("teste123");
		user.setPassword(passwordEncoder.encode(user.getPasswordAnterior()));
        user.setPermissions("");
        user.setPrimeiroAcesso(true);
		ur.save(user);
		
//		enviaEmailCadastroUsuario(user);
	}

	private void enviaEmailCadastroUsuario(User user) {
		SimpleMailMessage msgEmail = new SimpleMailMessage();
        msgEmail.setSubject("Bem-vindo ao EUVIN");
        msgEmail.setTo(user.getEmail());
        msgEmail.setText("Bem-vindo ao EUVIN!"
        		+ "Seu cadastro foi concluído com sucesso, vá ao endereço: http://localhost:8080/login e realize seu primeiro acesso."
        		+ "\nSua senha de primeiro acesso é: "+user.getPasswordAnterior()
        		+ "\nEm seu primeiro acesso, você deverá inserir a senha de sua preferência."
        		+ "\nUm muito obrigado da Equipe EUVIN!");
        mailSender.send(msgEmail);
	}
	
	public List<User> getUsuariosRole(String role){
		if(role!=null) {
			return ur.findByRoles(role);
		}
		
		return new ArrayList<User>();
	}
	
}
