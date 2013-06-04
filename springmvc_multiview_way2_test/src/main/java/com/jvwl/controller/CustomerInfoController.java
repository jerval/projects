package com.jvwl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jvwl.model.Customer;

@Controller
@RequestMapping("/customerInfo")
public class CustomerInfoController {

	@RequestMapping(value = "/new/{pageSize}/{pageNo}", method = RequestMethod.POST)
	//@ResponseBody//,@PathVariable Integer pageSize, @PathVariable Integer pageNo
	public @ResponseBody Customer newCustomer(@RequestBody Customer cust) {
		Customer customer = new Customer();
		customer.setName(cust.getName() + "经服务器修改");
		customer.setAddr(cust.getAddr() + "经服务器修改");
		System.out.println("CustomerInfoController for josn way2 newCustomer invoke!");
		
		System.out.println(cust);
		//System.out.println(pageNo+"    "+pageSize);
		return customer;
	}
}