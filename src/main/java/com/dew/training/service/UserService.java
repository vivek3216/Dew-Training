package com.dew.training.service;

import com.dew.training.dto.User;

public interface UserService {

	public User addUser(User user) throws Exception;

	public User signIn(User user);

	public User getUserByEmail(String email);
}
