package com.yquants.spring.tutorial.restful;

/**
 * @���� Winson
 * @�ʼ� laxsong@hotmail.com
 * @���� 2016-1-23
 * @���� �û�ʵ����
 */
public class User {
	private String userId;
	private String userName;

	public User() {
	}

	public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}