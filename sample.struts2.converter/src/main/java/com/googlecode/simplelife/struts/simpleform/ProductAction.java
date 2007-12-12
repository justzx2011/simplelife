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
package com.googlecode.simplelife.struts.simpleform;

import java.util.Date;

import com.googlecode.simplelife.struts.Product;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 最简单的表单处理
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Revision$<br />
 */
public class ProductAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private Long id;

	// 商品名称
	private String name;

	// 价格
	private float price;

	// 供货商
	private String vendor;

	private Date createDate;

	@Override
	public String execute() throws Exception {
		Product product = new Product();
		product.setCreateDate(this.createDate);
		product.setId(this.id);
		product.setName(this.name);
		product.setPrice(this.price);
		product.setVendor(this.vendor);

		System.out.println(product);

		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
