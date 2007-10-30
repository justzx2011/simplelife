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

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserDao的测试类
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public class UserDaoTest {

	private UserDao userDao;

	@Before
	public void init() {
		this.userDao = new UserDao();
		this.userDao.init();
	}

	@After
	public void close() {
		this.userDao.clear();
	}

	@Test
	public void test() {
		User user = new User();
		user.setUserName("zhangsan");
		user.setPassword("password");

		this.userDao.save(user);
		assert user.getId() != null;
		assert this.userDao.findById(user.getId()).getUserName().equals(
				"zhangsan");

		user.setPassword("password1");
		this.userDao.save(user);
		assert this.userDao.findById(user.getId()).getPassword().equals(
				"password1");

		List<User> users = this.userDao.findAll();
		assert users.size() == 1;
		assert users.get(0).getUserName().equals("zhangsan");

		this.userDao.delete(user.getId());
		users = this.userDao.findAll();
		assert users.size() == 0;
	}
}
