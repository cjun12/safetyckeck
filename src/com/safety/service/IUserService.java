package com.safety.service;

import java.util.List;

import com.safety.entity.User;

public interface IUserService {
	public void saveUser(User user);

	public void updateUser(User user);

	public User findUserById(int id);

	public void deleteUser(User user);

	public List<User> findAllList();

	public User findUserByNameAndPassword(String username, String password);

	public User findByUserName(String username);
}
