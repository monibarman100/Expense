package com.example.expensetracker.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.User;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {

	//SELECT *FROM tbl_expense WHERE type=?
	
	Page<Expense>findByType(String type,Pageable page);
	
	Page<Expense>findByCategory(String category,Pageable page);


}
