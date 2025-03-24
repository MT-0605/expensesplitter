package com.myapp.expensesplitter.service;

import com.myapp.expensesplitter.model.Expense;
import com.myapp.expensesplitter.repository.ExpenseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepo expenseRepo;

    public ExpenseService(@Autowired ExpenseRepo expenseRepo)
    {
        this.expenseRepo = expenseRepo;
    }

    @Transactional
    public List<Expense> findAll()
    {
        return expenseRepo.findAll();
    }

    @Transactional
    public Expense findById(int theId)
    {
        return expenseRepo.findById(theId);
    }

    @Transactional
    public void save(Expense expense)
    {
        expenseRepo.save(expense);
    }

    @Transactional
    public void deleteById(int theId)
    {
        expenseRepo.deleteById(theId);
    }
}
