package com.petmarket.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.petmarket.entities.ShoppingCart;
import com.petmarket.entities.User;
import com.petmarket.service.UserService;

public class UserAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> session;
	
	private UserService userService;
	
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	private String phoneNumber;// �������绰����
	private String password;
	private ShoppingCart shoppingCart;// ����1-1����ӳ��
	private String address;// �ջ���ַ
	private String gender;// �Ա�
	private Date birthday;// ����
	private String headerUrl;// ͷ��-->ʱ�䲻�����Բ�ʵ��
	
	private User user;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String signup(){
		user = new User(phoneNumber, password, address, gender, birthday, headerUrl);
		session.put("user",user);
		userService.saveOrUpdate(user);
		return "signup";
	}
		
	
	public String login(){
		user = userService.search(phoneNumber);
		session.put("user",user);
		if(user != null && user.getPassword().equals(password)){
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "login-failed";		
		}else{
			
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "login-failed";	
		}
	}
	
	public String validateUser(){
		
		if(session.get("user") != null){
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "validate";
		}else{
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "validate";
		}
	}
	
	public String home(){
		if(session.get("user") ==null){
			return "login";
		}else{
			return "home";
		}
	}
}
