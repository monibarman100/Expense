package com.example.expensetracker.dto;

import java.math.BigDecimal;


import lombok.Data;

@Data
public class UserDTO {
	
	private long id;
	private String userName;
	private String age;
	private String mobileNo;
	private BigDecimal emailId;
	
}
