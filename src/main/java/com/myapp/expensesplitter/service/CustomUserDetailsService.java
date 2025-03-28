package com.myapp.expensesplitter.service;

import com.myapp.expensesplitter.model.CustomUserDetails;
import com.myapp.expensesplitter.model.User;
import com.myapp.expensesplitter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("User not found!!");
        }

        return new CustomUserDetails(user);
    }
}
