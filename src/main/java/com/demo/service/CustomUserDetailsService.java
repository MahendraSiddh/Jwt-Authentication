package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.CustomUser;
import com.demo.model.UserPrincipal;
import com.demo.repository.CustomUserDeatilsRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CustomUserDeatilsRepo userDeatilsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = userDeatilsRepo.findByUsername(username);
        if(customUser==null)
        {
            throw new UsernameNotFoundException("user not found");
        }
        else
        {
            return new UserPrincipal(customUser);
        }
    }
}
