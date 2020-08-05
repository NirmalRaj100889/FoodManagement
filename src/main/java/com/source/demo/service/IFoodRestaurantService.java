package com.source.demo.service;

import java.util.List;
import com.source.demo.beans.RestaurantMenuEntity;

public interface IFoodRestaurantService {

	List<RestaurantMenuEntity> loadRestaurantMenus();

	boolean bookOrder(int menuId);

}
