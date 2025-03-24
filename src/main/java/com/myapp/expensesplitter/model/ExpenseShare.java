package com.myapp.expensesplitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "expense_shares")
public class ExpenseShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double amountOwed;

    public ExpenseShare() {
    }

    public ExpenseShare(int id, Expense expense, User user, double amountOwed) {
        this.id = id;
        this.expense = expense;
        this.user = user;
        this.amountOwed = amountOwed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    @Override
    public String toString() {
        return "ExpenseShare{" +
                "id=" + id +
                ", amountOwed=" + amountOwed +
                '}';
    }
}
