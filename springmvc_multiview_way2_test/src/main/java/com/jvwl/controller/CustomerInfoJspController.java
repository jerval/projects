package com.jvwl.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jvwl.model.Customer;

@Controller
@RequestMapping("/customerInfoJsp")
public class CustomerInfoJspController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newCustomer(Customer cust,Map model) {
		Customer customer = new Customer();
		customer.setName(cust.getName() + "经服务器修改");
		customer.setAddr(cust.getAddr() + "经服务器修改");
		System.out.println("CustomerInfoJsp for jsp way2Controller========= invoke!");
		System.out.println(customer);
		return "test";
	}
}