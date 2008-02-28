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
package com.googlecode.simplelife.product.business;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.simplelife.product.dao.CriteriaCallBack;
import com.googlecode.simplelife.product.dao.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品业务类
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public class ProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductDao productDao;

	private PhotoDao photoDao;

	private Product product;

	private Pagination<Product> pagination;

	private String id;

	private File file;

	private Photo photo;

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pagination<Product> getPagination() {
		return pagination;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String save() throws Exception {
		this.productDao.saveOrUpdate(this.product);
		if (this.file != null) {
			String id = (String) this.photoDao
					.findByCriteria(new CriteriaCallBack() {

						public void setCriteria(Criteria criteria) {
							criteria.add(Restrictions.eq("product", product))
									.setProjection(Projections.id());
						}
					});

			if (this.photo == null) {
				this.photo = new Photo();
			}
			InputStream inputStream = null;
			if (file==null||!file.exists()) {
				String path = Thread
						.currentThread()
						.getContextClassLoader()
						.getResource(
								"com/googlecode/simplelife/product/business/empty_photo.GIF")
						.getPath();
				file = new File(path.substring(1));
			}
			inputStream = new FileInputStream(file);
			this.photo.setData(new byte[(int) this.file.length()]);
			this.photo.setProduct(product);
			this.photo.setId(id);
			inputStream.read(this.photo.getData());
			inputStream.close();
			this.photoDao.saveOrUpdate(this.photo);
		}
		return "success";
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String delete() throws Exception {

		if (this.id != null) {

			this.product = this.productDao.findById(this.id);

			if (this.product != null) {
				this.photoDao.delete(this.product);
				this.productDao.delete(product);
			}
		}
		return "success";
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String detail() throws Exception {
		this.product = this.productDao.findById(this.id);

		if (this.product == null) {
			throw new ProductNotFoundException(MessageFormat.format(
					"ID为{0}的商品未找到.", this.id));
		}

		return "success";
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String update() throws Exception {
		this.product = this.productDao.findById(this.id);

		if (this.product == null) {
			throw new ProductNotFoundException(MessageFormat.format(
					"ID为{0}的商品未找到.", this.id));
		}

		return "success";
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String browse() throws Exception {
		this.productDao.findByCriteria(this.pagination);
		return "success";
	}
	

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InputStream getPhotoStream() {
		this.photo =this.photoDao.findByProductId(this.id);

		if (this.photo != null) {
			return new ByteArrayInputStream(this.photo.getData());
		}

		return this.getClass().getResourceAsStream("empty_photo.GIF");
	}

	public String getPhotoData() {
		return "success";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setPagination(Pagination<Product> pagination) {
		this.pagination = pagination;
	}

	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

}
