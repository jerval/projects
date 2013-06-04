package com.zk.spring.service;

import org.springframework.stereotype.Service;

import com.zk.spring.model.User;

@Service
public class UserService {

	private String name = "jerval";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(User user) {
		System.out.println("UserService add method invoked ! ");
	}

}
