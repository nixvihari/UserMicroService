package com.example.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.controller.UserController;
import com.example.app.repo.User;
import com.example.app.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;


	//Helpers
	private void updateHelper(User newUserDetails, User existingUser) {
		existingUser.setFirstName(newUserDetails.getFirstName());
		existingUser.setLastName(newUserDetails.getLastName());
		existingUser.setPhone(newUserDetails.getPhone());
		existingUser.setEmail(newUserDetails.getEmail());
	}
	
	//Basic CRUD
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	public User updateUser(Long userId, User newUserDetails) {
		Optional<User> existingUserOptional = getUserById(userId);
		
		if (existingUserOptional.isEmpty()) return null;
		
		User existingUser = existingUserOptional.get();
		updateHelper(newUserDetails, existingUser);
		
		return addUser(existingUser);
	}
}
