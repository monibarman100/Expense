package com.example.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User>getAllUsers(Pageable page) {
		return userService.getAllUsers(page).toList();
	}
	
	
	@GetMapping("{id}")
	public User getUserByID(@PathVariable Long id) {
		return userService.getUserByID(id);
	}
	
	@PostMapping
	public ResponseEntity<User> saveUsers(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUsers(user), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable ("id") Long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user,id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable ("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/login")
	public ModelAndView getUserByLogin(@RequestParam (required = false) String email, @RequestParam (required = false) String mobileNo) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user = userService.getUserByLogin(email,mobileNo);
		mav.setViewName("user/Login");
		return mav;
	}
	
	
}
