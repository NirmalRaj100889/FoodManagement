package com.source.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.source.demo.beans.RestaurantMenuEntity;
import com.source.demo.service.IFoodRestaurantService;

@RestController
public class FoodRestaurantController {
	
	@Autowired
	IFoodRestaurantService foodService;
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ResponseEntity<List<RestaurantMenuEntity>> loadMenusForRestaurant() {
		List<RestaurantMenuEntity> restaurantMenuList = foodService.loadRestaurantMenus();
		System.out.println("Inside Rest Call"+restaurantMenuList.size());
		
		if (restaurantMenuList.size()<1) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RestaurantMenuEntity>>(restaurantMenuList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/menu/{menuId}", method = RequestMethod.GET)
	public ResponseEntity<?> bookOrder(@PathVariable("menuId") int menuId) {
		try {
			boolean ordflag = foodService.bookOrder(menuId);
			if (!ordflag) {
				return new ResponseEntity(HttpStatus.CONFLICT);
			}
			return new ResponseEntity<String>("Order Booked",HttpStatus.CREATED);
		} catch (Exception e) {
			// Auto-generated catch block
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

}
