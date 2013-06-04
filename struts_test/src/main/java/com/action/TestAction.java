package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class TestAction {
	 @Action("foo")
	    public String foo() {
		 System.out.println("dddddd");
	        return "bar";
	    }

	 
	    @Action(value="foo-bar",results={@Result(name="sec",location="/tt.jsp")})
	    public String bar() {
	        return "sec";
	    }

}
