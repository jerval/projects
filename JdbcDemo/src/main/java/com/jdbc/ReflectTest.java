package com.jdbc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.jdbc.domain.User;

public class ReflectTest {

	public static void main(String[] args) {
		User user = new User(17, "usname", "pa", 23, new Date());
		// getConstractors(User.class);
		// getMethods(User.class,user);
		// getFields(User.class, user);
		getAnnotations(User.class);
	}

	public static void getConstractors(Class clazz) {
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			Class[] clazzs = constructor.getParameterTypes();
			for (Class cla : clazzs) {
				System.out.print(cla.getSimpleName() + "\t");
			}
			System.out.println();
		}
		Constructor constructor;
		try {
			constructor = clazz.getConstructor(Integer.class);
			Object object = constructor.newInstance(9);
			System.out.println(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getMethods(Class clazz, Object obj) {
		// Method[] methods = clazz.getDeclaredMethods();//取得当前类中所有方法，包括私有方法
		Method[] methods = clazz.getMethods();// 取得当前类和父类中所有的公有方法
		for (Method method : methods) {
			String methodName = method.getName();
			System.out.println(methodName);
			if ("setId".equals(methodName)) {
				try {
					method.invoke(obj, 10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			Method m = clazz.getMethod("setUsername", String.class);
			m.invoke(obj, "method reflect test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(obj);
	}

	public static void getFields(Class clazz, Object obj) {
		Field[] fields = clazz.getDeclaredFields();// 取得当前类中所有属性，包括私有属性
		// Field[] fields = clazz.getFields();//取得当前类和父类中所有的公有属性
		for (Field field : fields) {
			try {
				System.out.println(field.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Field f = clazz.getDeclaredField("id");
			f.setInt(obj, 99);// 出错，不能访问私有变量
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(obj);
	}

	public static void getAnnotations(Class clazz) {
//		Annotation[] annotations = clazz.getDeclaredAnnotations();// 取得当前类中所有注解，包括私有注解
		 Annotation[] annotations = clazz.getAnnotations();// 取得当前类和父类中所有的公有注解
		System.out.println(annotations.length);
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType());
		}
	}
}
