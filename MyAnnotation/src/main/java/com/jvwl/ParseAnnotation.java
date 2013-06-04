package com.jvwl;

import java.lang.reflect.Method;

public class ParseAnnotation {
public void parse(Object obj,String methodName){
	Method[] methods = obj.getClass().getMethods();
	for(Method method:methods){
		if(method.getName().equals(methodName)){
			MyAnnotation ma=method.getAnnotation(MyAnnotation.class);
			System.out.println(ma.value());
			try {
				System.out.println("before..."+ma.value());
				method.invoke(obj, null);
				System.out.println("end..."+ma.value());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
}
