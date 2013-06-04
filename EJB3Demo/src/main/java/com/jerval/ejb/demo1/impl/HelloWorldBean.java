package com.jerval.ejb.demo1.impl;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.jerval.ejb.demo1.HelloWorld;
import com.jerval.ejb.demo1.HelloWorldLocal;
import com.jerval.ejb.demo1.Other;

//无状态Bean
//@Stateless(name="aaa")修改HelloWorldBean名字为aaa
@Stateless
// 有状态Bean
// @Stateful
// 指定远程接口，如果不指定则使用本地Bean
@Remote(HelloWorld.class)
// 指定本地接口,这样无论是本地方式还是远程方式都可以访问EJB,如果不写默认为本地接口
@Local(HelloWorldLocal.class)
public class HelloWorldBean implements HelloWorld, HelloWorldLocal {
	/**
	 * 如何引用其它EJB对象
	 */
	// private Other other = new OtherBean();// 这是错误的，拿到的不是EJB对象，只是一个普通的Java对象
	// @EJB//按类类型注入，如果有多个实现类，将报异常
	@EJB(beanName = "OtherBean")//按类名称注入
	private Other other;

	@Override
	public String sayHello(String name) {
		String result = null;
		// way 1 直接返回字符串
		// result = name + " say: Hello World!";
		// way 2通过命名查找的方式得到其它EJB对象
		// try {
		// InitialContext initialContext = new InitialContext();
		// Other other = (Other) initialContext.lookup("OtherBean/local");
		// result = name + " say: Hello " + other.sayMe();
		// } catch (NamingException e) {
		// e.printStackTrace();
		// }
		// way 3通过EJB注解
		result = name + " ejb say: Hello " + other.sayMe();
		return result;
	}

}
