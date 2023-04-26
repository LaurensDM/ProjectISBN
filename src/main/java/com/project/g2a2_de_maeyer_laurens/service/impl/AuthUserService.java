package com.project.g2a2_de_maeyer_laurens.service.impl;

import com.project.g2a2_de_maeyer_laurens.config.AuthUserDetails;
import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(username);
         if(user == null){
              throw new UsernameNotFoundException("User not found");
            }
        System.out.println(user.toString());
        return new AuthUserDetails(user);
    }
}
