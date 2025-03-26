package com.myapp.expensesplitter.service;

import com.myapp.expensesplitter.model.User;
import com.myapp.expensesplitter.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public UserService(@Autowired UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    @Transactional
    public List<User> findAll()
    {
        return userRepo.findAll();
    }

    @Transactional
    public User findById(int theId)
    {
        return userRepo.findById(theId);
    }

    @Transactional
    public void save(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Transactional
    public void deleteById(int theId)
    {
        userRepo.deleteById(theId);
    }
}
