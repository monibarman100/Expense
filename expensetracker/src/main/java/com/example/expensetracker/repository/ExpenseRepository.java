package com.example.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;


public interface ExpenseRepository extends JpaRepository <Expense, Long> {

	@Query("FROM Expense as e WHERE e.id IS NOT NULL")
	List<ExpenseDTO> findById();


}
