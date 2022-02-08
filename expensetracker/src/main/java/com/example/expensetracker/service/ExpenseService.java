package com.example.expensetracker.service;

import java.util.List;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.dto.ExpenseDTO;

public interface ExpenseService {
	ExpenseDTO saveExpense(ExpenseDTO expense);

	List<Expense> getAllExpenses();

}
