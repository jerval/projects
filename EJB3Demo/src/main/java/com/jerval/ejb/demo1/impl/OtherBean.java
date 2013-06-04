package com.jerval.ejb.demo1.impl;

import javax.ejb.Stateless;

import com.jerval.ejb.demo1.Other;

@Stateless
public class OtherBean implements Other {

	@Override
	public String sayMe() {
		return "Jerval";
	}

}
