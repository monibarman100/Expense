package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
		
	}
//	@PostMapping("/user")
//	public User saveUsers() {
//		return userService.saveUser();
//	}

}
