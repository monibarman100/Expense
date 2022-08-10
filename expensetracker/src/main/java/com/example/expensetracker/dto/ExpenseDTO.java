package com.example.expensetracker.dto;

import java.math.BigDecimal;

import com.example.expensetracker.entity.User;

import lombok.Data;

@Data
public class ExpenseDTO {
	
	private long id;
	private String name;
	private String category;
	private String type;
	private BigDecimal amount;
	private User userId;
	
}
