package com.jdbc.factory;

import java.sql.Connection;

public interface IConnection {

	public <T> T doThing(Connection conn, Class<T> clazz) throws Exception;
}
