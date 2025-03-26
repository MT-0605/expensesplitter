package com.myapp.expensesplitter.repository;

import com.myapp.expensesplitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findById(int theId);
    User findByUsername(String username);
}
