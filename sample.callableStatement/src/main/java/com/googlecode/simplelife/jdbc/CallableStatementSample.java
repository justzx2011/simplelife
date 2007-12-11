/*
 * Copyright 2007 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *      
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.simplelife.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Revision$<br />
 */
public class CallableStatementSample {

	/**
	 * 使用存储过程保存用户
	 * 
	 * @param args
	 * @throws Exception
	 */
	public void insertUser(String userName) {
		Connection connection = null;
		try {
			connection = getConnection();
			CallableStatement statement = connection
					.prepareCall("{ call insert_demo_max(?)}");
			statement.setString(1, userName);
			statement.execute();
			statement.close();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
				}
			}
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	/**
	 * 得到连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		Connection connection;
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "marshal", "password");
		return connection;
	}
}
