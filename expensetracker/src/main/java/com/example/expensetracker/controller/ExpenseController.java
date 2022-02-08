package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {
	 
	@Autowired 
	private ExpenseService expenseService;
	
	@GetMapping
	public List<Expense> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@PostMapping
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
		return new ResponseEntity<Expense>(expenseService.saveExpense(expense), HttpStatus.CREATED);
		
	}
	
		
	
	
}
