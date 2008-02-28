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
package com.googlecode.simplelife.product;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.googlecode.simplelife.product.business.Product;
import com.googlecode.simplelife.product.business.ProductDao;

/**
 * ProductDao接口实现的单元测试
 * 
 * @author Marshal Wu
 * 
 * $Id$
 */
public class ProductDaoTest extends
		AbstractDependencyInjectionSpringContextTests {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:com/googlecode/simplelife/product/config.xml" };
	}

	@Test
	public void test() {
		Product product = new Product();
		product.setName("p");
		product.setPrice(111);

		this.productDao.saveOrUpdate(product);
		assert product.getId() != null;
		assert this.productDao.findById(product.getId()) != null;

		product.setPrice(112);
		this.productDao.saveOrUpdate(product);
		assert this.productDao.findById(product.getId()).getPrice() == 112;

		this.productDao.delete(product);
		assert this.productDao.findById(product.getId()) == null;
	}
}
