package com.myapp.expensesplitter.controller;

import com.myapp.expensesplitter.model.Expense;
import com.myapp.expensesplitter.model.User;
import com.myapp.expensesplitter.service.ExpenseService;
import com.myapp.expensesplitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService)
    {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<Expense> findAll()
    {
        return expenseService.findAll();
    }

    @PostMapping("/expenses")
    public Expense addExpense(@RequestBody Expense expense)
    {
        expenseService.save(expense);
        return expense;
    }

    @GetMapping("/expenses/{expenseId}")
    public Expense getExpense(@PathVariable int expenseId)
    {
        Expense expense = expenseService.findById(expenseId);
        if (expense == null) {
            throw new RuntimeException("Expense id not found - " + expenseId);
        }
        return expense;
    }

    @PutMapping("/expenses")
    public Expense updateExpense(@RequestBody Expense expense)
    {
        expenseService.save(expense);
        return expense;
    }

    @DeleteMapping("/expenses/{expenseId}")
    public String deleteUser(@PathVariable int expenseId) {

        Expense expense = expenseService.findById(expenseId);

        if (expense == null) {
            throw new RuntimeException("Expense id not found - " + expenseId);
        }

        expenseService.deleteById(expenseId);
        return "Deleted expense id - " + expenseId;
    }
}