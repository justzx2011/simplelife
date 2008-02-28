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
package com.googlecode.simplelife.product.dao;

import java.io.Serializable;

/**
 * Dao接口
 * 
 * @author Marshal Wu
 * 
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键属性类
 *          
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public interface Dao<T, PK extends Serializable> {

	/**
	 * 创建对象.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void create(T entity);

	/**
	 * 创建或更新对象
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 更新对象
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 通过id得到对象
	 * 
	 * @param id
	 * @return
	 */
	public T findById(PK id);

	/**
	 * 删除对象
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 分页浏览
	 * 
	 * @param pagination
	 */
	public void findByCriteria(Pagination<T> pagination);

	/**
	 * 根据条件查询
	 * 
	 * @param condition
	 * @return
	 */
	public Object findByCriteria(Object condition);

}
