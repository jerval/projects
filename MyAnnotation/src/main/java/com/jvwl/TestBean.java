package com.jvwl;

public class TestBean {
private String name;

@Override
@MyAnnotation("test")
public String toString(){
	return name;
}

public TestBean(){}

public TestBean(String name) {
	this.name = name;
}

}
