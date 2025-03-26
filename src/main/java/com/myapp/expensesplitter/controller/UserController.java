package com.myapp.expensesplitter.controller;

import com.myapp.expensesplitter.model.User;
import com.myapp.expensesplitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll()
    {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        userService.save(user);
        return user;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId)
    {
        User user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        return user;
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable int userId,@RequestBody User user)
    {
        User user1 = userService.findById(userId);
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user1.getPassword());
        user1.setRole(user.getRole());
        userService.save(user1);
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }
}