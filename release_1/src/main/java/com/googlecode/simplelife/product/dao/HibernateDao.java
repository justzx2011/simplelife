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
import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Hibernate与Spring集成的Dao实现.
 * 
 * @param <T>
 *            实体类
 * @param <PK>
 *            主键类
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public abstract class HibernateDao<T, PK extends Serializable> extends
		HibernateDaoSupport implements Dao<T, PK> {

	/** The type. */
	@SuppressWarnings("unchecked")
	protected Class type;

	/**
	 * Browse.
	 * 
	 * @param criteriaCallBack
	 *            the criteria call back
	 * @param pagination
	 *            the pagination
	 */
	@SuppressWarnings("unchecked")
	protected void browse(final Pagination<T> pagination,
			final CriteriaCallBack criteriaCallBack) {

		assert pagination.getSize() > 0;

		pagination.setRecordSum((Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session.createCriteria(type);
						criteriaCallBack.setCriteria(criteria);
						Integer count = (Integer) criteria.setProjection(
								Projections.count(Projections.id().toString()))
								.uniqueResult();
						return count;
					}
				}));

		if (pagination.getRecordSum() > 0) {
			pagination.setResults(this.getHibernateTemplate().executeFind(
					new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Criteria criteria = session.createCriteria(type);

							criteriaCallBack.setCriteria(criteria);

							if (pagination.getOrderFieldName() != null
									&& !pagination.getOrderFieldName().trim()
											.isEmpty()) {
								criteria.addOrder(pagination.isDesc() ? Order
										.desc(pagination.getOrderFieldName())
										: Order.asc(pagination
												.getOrderFieldName()));
							}

							criteria.setFirstResult(pagination.getSize()
									* (pagination.getNo() - 1));
							criteria.setMaxResults(pagination.getSize());
							return criteria.list();
						}
					}));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#browse(simple.life.dao.Pagination)
	 */
	@SuppressWarnings("unchecked")
	public void findByCriteria(final Pagination pagination) {

		CriteriaCallBack criteriaCallBack = null;

		if (pagination.getConditon() instanceof CriteriaCallBack) {
			criteriaCallBack = (CriteriaCallBack) pagination.getConditon();
		} else {
			criteriaCallBack = new CriteriaCallBack() {
				@Override
				public void setCriteria(Criteria criteria) {
				}
			};
		}

		this.browse(pagination, criteriaCallBack);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#get(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		return (T) this.getHibernateTemplate().get(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#create(java.lang.Object)
	 */
	public void create(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#update(java.lang.Object)
	 */
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simple.life.dao.Dao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the type
	 */
	@SuppressWarnings("unchecked")
	public void setType(Class type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByCriteria(Object condition) {

		if (condition instanceof CriteriaCallBack) {
			final CriteriaCallBack criteriaCallBack = (CriteriaCallBack) condition;
			return (T) this.getHibernateTemplate().execute(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Criteria criteria = session.createCriteria(type);
							criteriaCallBack.setCriteria(criteria);
							return criteria.uniqueResult();
						}

					});
		}
		return null;
	}

}
