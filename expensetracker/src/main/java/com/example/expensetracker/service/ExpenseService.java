package com.example.expensetracker.service;

import java.util.List;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;

public interface ExpenseService {
	ExpenseDTO saveExpense(ExpenseDTO expenseDTO);

	List<ExpenseDTO> getAllExpenses();

	Expense saveExpense(Expense expense);

	Expense updateExpense(Expense expense, long id);
	
	void deleteExpense(long id);

	Expense getExpenceById(Long id);

}
