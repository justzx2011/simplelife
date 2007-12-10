package com.googlecode.simplelife.jdbc;

import org.junit.Before;
import org.junit.Test;

public class CallableStatementSampleTest {

	private CallableStatementSample sample;

	@Before
	public void init() {
		this.sample = new CallableStatementSample();
	}

	@Test
	public void testInsertUser() {
		String userName = "zhangsan";
		this.sample.insertUser(userName);
	}
}
