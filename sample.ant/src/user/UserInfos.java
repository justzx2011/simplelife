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
package user;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 用户信息处理类
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public abstract class UserInfos {

	private static Set<UserInfo> users;

	static {
		UserInfo admin = new UserInfo();
		admin.setName("管理员");
		admin.setUserName("admin");
		admin.setPassword("password");
		admin.setEmail("admin@google.com");

		users = new HashSet<UserInfo>();
		users.add(admin);
	}

	/**
	 * 获取全部用户的集合
	 * 
	 * @return 用户的集合
	 */
	public static Set<UserInfo> getUsers() {
		return users;
	}

	/**
	 * 根据用户名查找对应的用户信息
	 * 
	 * @param userName
	 * @return 对应的用户信息或者null
	 */
	public static UserInfo find(String userName) {
		for (UserInfo user : users) {
			if (userName.equals(user.getUserName())) {
				return user;
			}
		}

		return null;
	}

	/**
	 * 保存用户信息
	 * 
	 * @param userInfo
	 */
	public static void save(UserInfo userInfo) {

		if (users.contains(userInfo)) {
			users.remove(userInfo);
		}

		users.add(userInfo);
	}

	/**
	 * 根据用户名列表批量删除对应的用户信息
	 * 
	 * @param userNames
	 */
	public static void delete(List<String> userNames) {

		for (Iterator<UserInfo> iterator = users.iterator(); iterator.hasNext();) {

			UserInfo user = iterator.next();

			if (!user.getUserName().equals("admin")
					&& userNames.contains(user.getUserName())) {
				iterator.remove();
			}
		}
	}

	private UserInfos() {
	}

}
