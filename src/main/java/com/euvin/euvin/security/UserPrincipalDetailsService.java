package com.euvin.euvin.security;

import com.euvin.euvin.models.User;
import com.euvin.euvin.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("Usuário não existe!");
        } 
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }

}