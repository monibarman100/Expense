package com.example.expensetracker.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;


public interface ExpenseService {
	ExpenseDTO saveExpense(ExpenseDTO expenseDTO);

	Page<Expense> getAllExpenses(Pageable page);

	//Expense saveExpense(Expense expense);

	Expense updateExpense(Expense expense, long id);
	
	void deleteExpense(long id);

	Expense getExpenceById(Long id);

	Page<Expense> getExpenseByType(String type,Pageable page);

	Page<Expense> getExpenseBycategory(String category,Pageable page);

	public Expense saveExpenseByUser(Expense expense, Long user_Id);

}
