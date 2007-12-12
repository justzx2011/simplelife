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
package com.googlecode.simplelife.struts.converter;

import java.lang.reflect.Member;
import java.util.Map;

import ognl.DefaultTypeConverter;

public class ContactConverter extends DefaultTypeConverter {
	@Override
	public Object convertValue(Map context, Object target, Member member,
			String propertyName, Object value, Class toType) {
		if (toType == Person.class) {
			String contactName = ((String[]) value)[0];
			Person person = new Person();
			person.setName(contactName);
			return person;
		}

		if (toType == String.class) {
			Person person = (Person) value;
			return person.getName();
		}
		
		return null;
	}
}
