package com.paydayplanner.repository;

import com.paydayplanner.model.Expense;

import java.util.List;

public interface ExpenseRepository<T extends Expense> {
    List<T> listAll();
    void persist(T expense);
    void deleteById(Long id);
}
