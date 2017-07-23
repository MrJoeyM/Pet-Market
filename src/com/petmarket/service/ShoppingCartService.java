package com.petmarket.service;

import java.util.ArrayList;
import java.util.List;

import com.petmarket.dao.ShoppingCartDao;
import com.petmarket.entities.Pet;
import com.petmarket.entities.PetPics;
import com.petmarket.entities.ShoppingCart;

public class ShoppingCartService {
	
	private ShoppingCartDao shoppingCartDao;
	
	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}
	
	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}
	
	//��ȡ���ﳵ�����еĳ�����Ϣ
	public List<Pet> getPetsFromShoppingCart(String userId){
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getMyShoppingChart(userId);
		List<Pet> pets = new ArrayList<Pet>();
		for (ShoppingCart shoppingCart : shoppingCarts) {
			List<PetPics> petPics = shoppingCartDao.getPics(shoppingCart.getPetId());
			Pet pet = shoppingCartDao.getPet(shoppingCart.getPetId());
			pet.setPictures(petPics);
			pet.setShoppingCart(shoppingCart);
			pets.add(pet);
		}
		return pets;
	}
	
	//��ȡ���ﳵ����Ʒ�ܼ�
	public Integer getTotalPrice(String userId){
		int totalPrice = 0;
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getMyShoppingChart(userId);
		for (ShoppingCart shoppingCart : shoppingCarts) {
			Pet pet = shoppingCartDao.getPet(shoppingCart.getPetId());
			totalPrice += shoppingCart.getNumber() * pet.getPrice();
		}
		return totalPrice;
	}
	
	//��ȡ���û������Ĺ��ﳵ
	public List<ShoppingCart> showShoppingCart(String userId) {
		return shoppingCartDao.getMyShoppingChart(userId);
	}
	
	//�����Ʒ�����ﳵ
	public void addToShoppingCart (ShoppingCart shoppingCart) {
		ShoppingCart s = shoppingCartDao.getExistedShoppingCart(shoppingCart);
		if(s != null) {
			shoppingCartDao.updateNumberOfShoppingCart(s, shoppingCart.getNumber());
		} else {
			shoppingCartDao.saveOrUpdateShoppingCart(shoppingCart);
		}
	}
	
	//��ȡ��Ʒ�ܼ�
	public Integer getPetPrice(String userId,Integer petId){
		int petPrice = 0;
		Pet pet = shoppingCartDao.getPet(petId);
		ShoppingCart shoppingCart = shoppingCartDao.getShoppingCart(userId, petId);
		petPrice = pet.getPrice()*shoppingCart.getNumber();
		return petPrice;
	}
	
	//ɾ�����ﳵ�еļ�¼
	public void deleteItem(Integer petId,String userId){
		shoppingCartDao.deleteItem(petId, userId);
	}

}
