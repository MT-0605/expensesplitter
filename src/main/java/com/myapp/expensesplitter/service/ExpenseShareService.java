package com.myapp.expensesplitter.service;

import com.myapp.expensesplitter.model.ExpenseShare;
import com.myapp.expensesplitter.model.User;
import com.myapp.expensesplitter.repository.ExpenseShareRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseShareService {
    public ExpenseShareRepo expenseShareRepo;

    public ExpenseShareService(@Autowired ExpenseShareRepo expenseShareRepo)
    {
        this.expenseShareRepo = expenseShareRepo;
    }

    @Transactional
    public List<ExpenseShare> findAll()
    {
        return expenseShareRepo.findAll();
    }

    @Transactional
    public ExpenseShare findById(int theId)
    {
        return expenseShareRepo.findById(theId);
    }

    @Transactional
    public void save(ExpenseShare expenseShare)
    {
        expenseShareRepo.save(expenseShare);
    }

    @Transactional
    public void deleteById(int theId)
    {
        expenseShareRepo.deleteById(theId);
    }
}