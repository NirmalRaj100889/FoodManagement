package com.source.demo.beans;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;

@Component
public class RestaurantMenuEntity {
	
	private int menuId;
	private String menuName;
	private double price;
	private String category;
	
	public RestaurantMenuEntity() {}
	
	
	public RestaurantMenuEntity(int menuId, String menuName, double price, String category) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
