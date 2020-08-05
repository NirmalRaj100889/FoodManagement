package com.source.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.source.demo.beans.RestaurantMenuEntity;

@Repository
public class FoodRestaurantReopImpl  implements IFoodRestaurantRepo{
	
	@Autowired
	RestaurantMenuEntity foodMenu;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RestaurantMenuEntity> getFoodMenuList() {
		// TODO Auto-generated method stub
		List<RestaurantMenuEntity> restaurantEntityList = new ArrayList<>();
		Session currentSession = sessionFactory.getCurrentSession();
		/*
		 * restaurantEntityList = currentSession .createQuery("from RestaurantMenuEntity",
		 * RestaurantMenuEntity.class) .getResultList();
		 */
		
		restaurantEntityList = constructFoodMenu();
		return restaurantEntityList;
	}

	@Override
	public boolean processOrder(int menuId) {
		
		List<RestaurantMenuEntity> menuList = constructFoodMenu();
		Session currentSession = sessionFactory.getCurrentSession();
		/*
		 * menuList = currentSession
		 * .createQuery("from RestaurantMenuEntity where menuId=:menuId",
		 * RestaurantMenuEntity.class) .setParameter("menuId", menuId).getResultList();
		 */
		
		for(RestaurantMenuEntity menu: menuList) {
			if(menu.getMenuId() == menuId) {
				return true;
			}
		}
		
		return false;
	}
	
	private List<RestaurantMenuEntity> constructFoodMenu(){
		
		RestaurantMenuEntity breakFast =new RestaurantMenuEntity(101,"Sandwich",100.00,"BreakFast");
		RestaurantMenuEntity lunch =new RestaurantMenuEntity(102,"Pizza",150.00,"lunch");
		RestaurantMenuEntity dinner =new RestaurantMenuEntity(103,"Burger",80.00,"dinner");
		RestaurantMenuEntity snacks =new RestaurantMenuEntity(104,"French Fries",50.00,"snacks");
		System.out.println("Inside the loop");
		List<RestaurantMenuEntity> menuList = new ArrayList<>();
		menuList.add(dinner);menuList.add(breakFast);menuList.add(snacks);menuList.add(lunch);
		
		
		
		
		return menuList;
		
	}
 
}
