package com.example.expensetracker.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ExpenseDTO {
	
	private long id;
	private String name;
	private String category;
	private String type;
	private BigDecimal amount;
	
}
