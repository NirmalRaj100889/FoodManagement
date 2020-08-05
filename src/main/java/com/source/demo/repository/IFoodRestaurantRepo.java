package com.source.demo.repository;

import java.util.List;

import com.source.demo.beans.RestaurantMenuEntity;

public interface IFoodRestaurantRepo {

	List<RestaurantMenuEntity> getFoodMenuList();

	boolean processOrder(int id);

}
