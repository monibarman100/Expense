package com.example.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;

@SpringBootApplication
public class ExpensetrackerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		this.expenseRepository.save(new Expense());
	}

}
