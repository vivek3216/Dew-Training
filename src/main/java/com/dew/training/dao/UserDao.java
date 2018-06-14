package com.dew.training.dao;

import com.dew.training.dto.User;

public interface UserDao {

	public User addUser(User user) throws Exception;

	public User signIn(User user);

	public User getUserByEmail(String email);
}
