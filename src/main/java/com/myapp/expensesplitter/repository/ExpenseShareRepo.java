package com.myapp.expensesplitter.repository;

import com.myapp.expensesplitter.model.ExpenseShare;
import com.myapp.expensesplitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseShareRepo extends JpaRepository<ExpenseShare,Integer> {
    ExpenseShare findById(int theId);
}
