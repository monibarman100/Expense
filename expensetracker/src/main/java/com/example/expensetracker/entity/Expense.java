package com.example.expensetracker.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_expence")
@Data
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="expense_name")
	private String name;
	@Column(name ="category")
	private String category;
	@Column(name ="type")
	private String type;
	@Column(name ="expense_amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User userId;
	
	
	
}
