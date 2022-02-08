package com.example.expensetracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired 
	private ExpenseRepository expenseRepository;

	@Override
	public ExpenseDTO saveExpense(ExpenseDTO expense) {
		Expense expenceSet = new Expense();
		expenceSet.setName(expense.getName());
		expenceSet.setCategory(expense.getCategory());
		expenceSet.setType(expense.getType());
		expenceSet.setAmount(expense.getAmount());
		expenseRepository.save(expenceSet);
		return null;
	}

	@Override
	public List<Expense> getAllExpenses() {
		List<Expense> expenseGet = expenseRepository.findById();
		return expenseGet;
		
	}

	
	
}
