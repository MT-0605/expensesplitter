package com.myapp.expensesplitter.controller;

import com.myapp.expensesplitter.model.ExpenseShare;
import com.myapp.expensesplitter.service.ExpenseShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseShareController {

    private ExpenseShareService expenseShareService;

    @Autowired
    public ExpenseShareController(ExpenseShareService expenseShareService) {
        this.expenseShareService = expenseShareService;
    }

    @GetMapping("/expense-shares")
    public List<ExpenseShare> findAll() {
        return expenseShareService.findAll();
    }

    @PostMapping("/expense-shares")
    public ExpenseShare addExpenseShare(@RequestBody ExpenseShare expenseShare) {
        expenseShareService.save(expenseShare);
        return expenseShare;
    }

    @GetMapping("/expense-shares/{expenseShareId}")
    public ExpenseShare getExpenseShare(@PathVariable int expenseShareId) {
        ExpenseShare expenseShare = expenseShareService.findById(expenseShareId);
        if (expenseShare == null) {
            throw new RuntimeException("ExpenseShare id not found - " + expenseShareId);
        }
        return expenseShare;
    }

    @PutMapping("/expense-shares/{expenseShareId}")
    public ExpenseShare updateExpenseShare(@PathVariable int expenseShareId,@RequestBody ExpenseShare expenseShare) {
        ExpenseShare expenseShare1 = expenseShareService.findById(expenseShareId);
        expenseShare1.setExpense(expenseShare.getExpense());
        expenseShare1.setId(expenseShare.getId());
        expenseShare1.setAmountOwed(expenseShare.getAmountOwed());
        expenseShare1.setUser(expenseShare.getUser());
        expenseShareService.save(expenseShare1);
        return expenseShare1;
    }

    @DeleteMapping("/expense-shares/{expenseShareId}")
    public String deleteExpenseShare(@PathVariable int expenseShareId) {
        ExpenseShare expenseShare = expenseShareService.findById(expenseShareId);
        if (expenseShare == null) {
            throw new RuntimeException("ExpenseShare id not found - " + expenseShareId);
        }
        expenseShareService.deleteById(expenseShareId);
        return "Deleted ExpenseShare id - " + expenseShareId;
    }
}
