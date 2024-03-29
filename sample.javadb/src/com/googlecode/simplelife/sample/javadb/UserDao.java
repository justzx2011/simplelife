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
package com.googlecode.simplelife.sample.javadb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * User实体Dao
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public class UserDao {

	public void clear() {
		Connection connection = null;

		try {
			connection = this.getConnection();
			this.dropTable(connection);
			connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
		}
	}

	private void create(User user) {
		Connection connection = null;

		try {
			connection = this.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("insert into users (user_name,password) values(?,?)");

			int index = 1;
			statement.setString(index++, user.getUserName());
			statement.setString(index++, user.getPassword());

			statement.execute();

			user.setId(this.getId(connection));

			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private void update(User user) {
		Connection connection = null;

		try {
			connection = this.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update users set user_name=?,password=? where id=?");

			int index = 1;
			statement.setString(index++, user.getUserName());
			statement.setString(index++, user.getPassword());
			statement.setLong(index++, user.getId());

			statement.execute();

			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private void createTable(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();

		String sql = "create table USERS("
				+ "   ID                           BIGINT                       not null generated by default as identity,"
				+ "   USER_NAME            VARCHAR(20)            not null,"
				+ "   PASSWORD             VARCHAR(20),"
				+ "   constraint P_KEY_1 primary key (ID))";
		statement.execute(sql);

		sql = "create unique index USER_NAME_INDEX on USERS ("
				+ "   USER_NAME            ASC)";
		statement.execute(sql);

		statement.close();
	}

	public void delete(Long id) {
		Connection connection = null;

		try {
			connection = this.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from users where id=?");
			statement.setLong(1, id);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private void dropTable(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("drop index USER_NAME_INDEX");
		statement.execute("drop table USERS");
		statement.close();
	}

	public List<User> findAll() {
		Connection connection = null;

		try {
			connection = this.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select id,user_name,password from users");

			List<User> users = new ArrayList<User>();

			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
				users.add(user);
			}

			resultSet.close();
			statement.close();
			connection.commit();
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	public User findById(Long id) {
		Connection connection = null;

		try {
			connection = this.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("select user_name,password from users where id=?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();

			User user = null;

			if (resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
			}

			resultSet.close();
			statement.close();
			connection.commit();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:derby:userDB;create=true;user=test;password=test");
		connection.setAutoCommit(false);
		return connection;
	}

	private Long getId(Connection connection) throws SQLException {
		CallableStatement callableStatement = connection
				.prepareCall("values identity_val_local()");

		ResultSet resultSet = callableStatement.executeQuery();
		resultSet.next();
		Long id = resultSet.getLong(1);
		resultSet.close();
		callableStatement.close();
		return id;
	}

	private boolean hasTable(Connection connection) throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet resultSet = metaData.getTables(null, null, "USERS",
				new String[] { "TABLES" });
		boolean hasTable = resultSet.next();
		resultSet.close();
		return hasTable;
	}

	public void init() {
		Connection connection = null;

		try {
			connection = this.getConnection();
			if (!this.hasTable(connection)) {
				this.createTable(connection);
			}
			connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				close(connection);
			}
		}
	}

	private void rollback(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
		}
	}

	public void save(User user) {
		if (user.getId() == null) {
			this.create(user);
		} else {
			this.update(user);
		}
	}
}
