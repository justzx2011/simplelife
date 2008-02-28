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

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.googlecode.simplelife.product.dao.HibernateDao;

/**
 * PhotoDao的实现类
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public class PhotoDaoImpl extends HibernateDao<Photo, String> implements
		PhotoDao {

	@Override
	public void delete(final Product product) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("delete from Photo p where p.product=?");
				query.setParameter(0, product);
				return query.executeUpdate();
			}

		});
	}

	@Override
	public Photo findByProductId(final String id) {
		return (Photo) this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from Photo p where p.product.id=?");
						query.setParameter(0, id);
						return query.uniqueResult();
					}

				});
	}

}
