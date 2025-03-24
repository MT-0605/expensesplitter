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

    @PutMapping("/users")
    public User updateUser(@RequestBody User user)
    {
        userService.save(user);
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