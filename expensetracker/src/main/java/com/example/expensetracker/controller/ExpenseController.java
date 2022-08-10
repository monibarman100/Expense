package com.example.expensetracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}

	@GetMapping("{id}")
	public Expense getExpenceById(@PathVariable Long id) {
		return expenseService.getExpenceById(id);
	}

//	@PostMapping
//	public ResponseEntity<ExpenseDTO> saveExpense(@RequestBody ExpenseDTO expenseDTO) {
//		return new ResponseEntity<ExpenseDTO>(expenseService.saveExpense(expenseDTO), HttpStatus.CREATED);
//
//	}

	@PutMapping("{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable("id") long id, @RequestBody Expense expense) {
		return new ResponseEntity<Expense>(expenseService.updateExpense(expense, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable("id") long id) {
		expenseService.deleteExpense(id);
		return new ResponseEntity<String>("Deleted Successful", HttpStatus.OK);
	}

	@GetMapping("types")
	public List<Expense> getExpenseByType(@RequestParam String type, Pageable page) {
		return expenseService.getExpenseByType(type, page).toList();
	}

	@GetMapping("categories")
	public List<Expense> getExpenseBycategory(@RequestParam String category, Pageable page) {
		return expenseService.getExpenseBycategory(category, page).toList();
	}

	@PostMapping
	public String saveExpense(@RequestBody Expense expense, @RequestParam Long user_Id) {
		expenseService.saveExpenseByUser(expense, user_Id);
		return "OK";

	}

}
