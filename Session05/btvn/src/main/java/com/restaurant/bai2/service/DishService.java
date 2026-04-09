package com.restaurant.bai2.service;

import com.restaurant.bai2.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();

        dishes.add(new Dish(1L, "Phở bò", 45000.0, true));
        dishes.add(new Dish(2L, "Bún chả", 50000.0, true));
        dishes.add(new Dish(3L, "Cơm rang", 60000.0, false));

        return dishes;
    }
}