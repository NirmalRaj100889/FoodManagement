package com.source.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.demo.beans.RestaurantMenuEntity;
import com.source.demo.repository.IFoodRestaurantRepo;


@Service
public class FoodRestaurantServiceImpl  implements IFoodRestaurantService{

	@Autowired
	private IFoodRestaurantRepo foodRepo;
	
	@Override
	public List<RestaurantMenuEntity> loadRestaurantMenus() {
		// TODO Auto-generated method stub
		return foodRepo.getFoodMenuList();
	}

	@Override
	public boolean bookOrder(int menuId) {
		// TODO Auto-generated method stub
		return foodRepo.processOrder(menuId);
	}

}
