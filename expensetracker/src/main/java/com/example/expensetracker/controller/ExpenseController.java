package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {
	 
	@Autowired 
	private ExpenseService expenseService;
	
	@GetMapping
	public List<ExpenseDTO> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("{id}")
	public Expense getExpenceById(@PathVariable Long id) {
		return expenseService.getExpenceById(id);
	}
	
	@PostMapping
	public ResponseEntity<ExpenseDTO> saveExpense(@RequestBody ExpenseDTO expenseDTO){
		return new ResponseEntity<ExpenseDTO>(expenseService.saveExpense(expenseDTO), HttpStatus.CREATED);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable("id") long id
												,@RequestBody Expense expense){
		return new ResponseEntity<Expense>(expenseService.updateExpense(expense,id), HttpStatus.OK);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable ("id") long id){
		expenseService.deleteExpense(id);
		return new ResponseEntity<String>("Deleted Successful", HttpStatus.OK);
	}
	
}
