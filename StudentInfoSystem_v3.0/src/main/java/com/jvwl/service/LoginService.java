package com.jvwl.service;

import com.jvwl.model.User;


public interface LoginService {

	public User login(String username,String password);

}