package com.example.expensetracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private ExpenseRepository expenseRepository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

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

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense, long id) {
		Expense existingExpense =expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense", "Id", id));
		existingExpense.setName(expense.getName());
		existingExpense.setCategory(expense.getCategory());
		existingExpense.setType(expense.getType());
		existingExpense.setAmount(expense.getAmount());
		expenseRepository.save(existingExpense);
		return null;
	}

	@Override
	public void deleteExpense(long id) {
		expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense", "Id", id));
		expenseRepository.deleteById(id);
		
	}

	
	
}
