package com.example.expensetracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.repository.UserRepository;
import com.example.expensetracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> getAllUsers(Pageable page) {
		return userRepository.findAll(page);
	}

	@Override
	public User saveUsers(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		User existingUser = getUserByID(id);
		existingUser.setUserName(user.getUserName());
		existingUser.setAge(user.getAge());
		existingUser.setMobileNo(user.getMobileNo());
		existingUser.setEmailId(user.getEmailId());
		return userRepository.save(existingUser);
	}

	@Override
	public User getUserByID(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public void deleteUser(Long id) {
		getUserByID(id);
		userRepository.deleteById(id);
	}

	@Override
	public User getUserByLogin(String email,String mobileNo) {
		User emp = new User();
		emp = userRepository.getUserByEmailIdAndMobileNo(email,mobileNo);
		if(emp != null) {
			return emp;
	}
		return emp;
	
	}
}
