package com.example.expensetracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	

	@Override
	public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {
		//Gson gson = new Gson();
		Expense expenceSet = new Expense();
		expenceSet.setName(expenseDTO.getName());
		expenceSet.setCategory(expenseDTO.getCategory());
		expenceSet.setType(expenseDTO.getType());
		expenceSet.setAmount(expenseDTO.getAmount());
	//	Expense expense = gson.fromJson(gson.toJston(expenseDTO), Expense.class);
		expenseRepository.save(expenceSet);
		
		return null;
	}

	@Override
	public List<ExpenseDTO> getAllExpenses() {
		List<ExpenseDTO> expenseGet = expenseRepository.findById();
		return expenseGet;
	}

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense, long id) {
		Expense existingExpense =getExpenceById(id);
		existingExpense.setName(expense.getName());
		existingExpense.setCategory(expense.getCategory());
		existingExpense.setType(expense.getType());
		existingExpense.setAmount(expense.getAmount());
		expenseRepository.save(existingExpense);
		return null;
	}

	@Override
	public void deleteExpense(long id) {
		getExpenceById(id);
		expenseRepository.deleteById(id);
		
	}

	@Override
	public Expense getExpenceById(Long id) {
		return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense", "Id", id));
		 
	}

	
}
