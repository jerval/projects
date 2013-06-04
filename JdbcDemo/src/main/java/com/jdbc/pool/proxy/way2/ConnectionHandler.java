package com.jdbc.pool.proxy.way2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

class ConnectionHandler implements InvocationHandler {

	private Connection realConnection;
	private Connection wrapedConnection;
	private int maxUseCount = 5;
	private int currentUseCount = 0;

	Connection bind(Connection realConnection) {
		this.realConnection = realConnection;
		Connection wrapedConnection = (Connection) Proxy.newProxyInstance(this
				.getClass().getClassLoader(), new Class[] { Connection.class },
				this);
		return wrapedConnection;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if ("close".equals(method.getName())) {
			currentUseCount++;
			if (currentUseCount < maxUseCount) {
				DataSource2.close(wrapedConnection);
			} else {
				realConnection.close();
				DataSource2.decrease();
			}
		}
		return method.invoke(realConnection, args);
	}

}
