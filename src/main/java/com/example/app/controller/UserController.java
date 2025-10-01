package com.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.repo.User;
import com.example.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") Long userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable("userId") Long userId, @RequestBody User newUserDetails) {
		return userService.updateUser(userId, newUserDetails);
	}
}
