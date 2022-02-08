package com.example.expensetracker.service;

import java.util.List;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;

public interface ExpenseService {
	ExpenseDTO saveExpense(ExpenseDTO expense);

	List<Expense> getAllExpenses();

	Expense saveExpense(Expense expense);

}
