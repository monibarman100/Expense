package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/")
public class ExpenseController {
	 
	@Autowired 
	private ExpenseService expenseService;
	
	@GetMapping("expenses")
	public List<Expense> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	
		
	
	
}
