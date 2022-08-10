package com.example.expensetracker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.repository.UserRepository;
import com.example.expensetracker.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private UserRepository userRepository;

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
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepository.findAll(page);
	}

//	@Override
//	public Expense saveExpense(Expense expense) {
//		return expenseRepository.save(expense);
//	}

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

	@Override
	public Page<Expense> getExpenseByType(String type,Pageable page) {
		return expenseRepository.findByType(type,page);
	}

	@Override
	public Page<Expense> getExpenseBycategory(String category,Pageable page) {
		return expenseRepository.findByCategory(category,page);
	}

	@Override
	public Expense saveExpenseByUser(Expense expense, Long user_Id) {
		Optional<User> userGet = userRepository.findById(user_Id);
		expense.setUserId(userGet.get());
		return expenseRepository.save(expense);
	}

//	@Override
//	public Expense saveExpenseByUser(Expense expense, Long user_Id) {
//		Optional<User> userGet = userRepository.findById(user_Id);
//		expense.setUserId(userGet.get());
//		return expenseRepository.save(expense);
//		
//	}
	
}
