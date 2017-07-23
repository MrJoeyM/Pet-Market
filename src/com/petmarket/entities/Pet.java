package com.petmarket.entities;

import java.util.List;
import java.util.Set;

public class Pet {
	private Integer petId;// ����id
	private String name;// ��������
	private Integer price;// �۸�
	private Integer number;// �������
	private String introduction;// ���
	private ShoppingCart shoppingCart;//�������ﳵ
	private List<PetPics> pictures;
	private String shape;//����
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCoatColour() {
		return coatColour;
	}

	public void setCoatColour(String coatColour) {
		this.coatColour = coatColour;
	}

	private Integer weight;//����
	private String coatColour;//ëɫ
	
	
	public Pet(){
		
	}
	
	public Pet(String name, Integer price, Integer number, String introduction) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
		this.introduction = introduction;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<PetPics> getPictures() {
		return pictures;
	}

	public void setPictures(List<PetPics> pictures) {
		this.pictures = pictures;
	}

}
