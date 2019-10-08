package com.euvin.euvin.repository;

import com.euvin.euvin.models.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Dbinit implements CommandLineRunner{

    private UserRepository ur;
    private PasswordEncoder passwordEncoder;

    public Dbinit(UserRepository ur, PasswordEncoder passwordEncoder){
        this.ur = ur;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        this.ur.deleteAll();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRoles("ADMIN");
        admin.setPermissions("");

        User usuario = new User();
        usuario.setUsername("usuario");
        usuario.setPassword(passwordEncoder.encode("usuario123"));
        usuario.setRoles("USER");
        usuario.setPermissions("");

        this.ur.save(admin);
        this.ur.save(usuario);
    }
}