package com.example.expensetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="user_name")
	private String userName;
	@Column(name ="age")
	private int age;
	@Column(name ="mobile_No")
	private String mobileNo;
	@Column(name ="email_Id")
	private String emailId;
	
	
	
}
