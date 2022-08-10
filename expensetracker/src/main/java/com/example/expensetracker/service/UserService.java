package com.example.expensetracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.expensetracker.entity.User;

public interface UserService {

	Page<User> getAllUsers(Pageable page);

	User saveUsers(User user);

	User updateUser(User user, Long id);

	User getUserByID(Long id);

	void deleteUser(Long id);

	User getUserByLogin(String email,String mobileNo);

	
	

	

	
}
