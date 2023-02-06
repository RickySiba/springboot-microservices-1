package com.deloitte.userms.services;

import java.util.List;

import com.deloitte.userms.models.User;

public interface UserService {
	public List<User> getUsers();
	public User findByUserId(Integer id);
	public User addUser(User user);
	public User deleteUser(Integer id);
}
