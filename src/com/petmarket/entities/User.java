package com.petmarket.entities;

import java.util.Date;

public class User {

	private String phoneNumber;// �������绰����
	private String password;
	private ShoppingCart shoppingCart;// ����1-1����ӳ��
	private String address;// �ջ���ַ
	private String gender;// �Ա�
	private Date birthday;// ����
	private String headerUrl;// ͷ��-->ʱ�䲻�����Բ�ʵ��

	public User() {

	}

	public User(String phoneNumber, String password, String address, String gender,
			Date birthday, String headerUrl) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.headerUrl = headerUrl;
	}

	public String getHeaderUrl() {
		return headerUrl;
	}

	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
