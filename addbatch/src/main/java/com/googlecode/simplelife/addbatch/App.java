package com.googlecode.simplelife.addbatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "marshal", "password");
		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into addbatch_test(id,name) values(?,?)");

		int size = 1000000;

		for (int i = 0; i < size; i++) {
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, "n" + i);
			preparedStatement.addBatch();
		}

		preparedStatement.executeBatch();

		preparedStatement.close();
		connection.close();
	}
}
