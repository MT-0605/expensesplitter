package com.myapp.expensesplitter.repository;


import com.myapp.expensesplitter.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Integer> {
    Expense findById(int expenseId);
}
