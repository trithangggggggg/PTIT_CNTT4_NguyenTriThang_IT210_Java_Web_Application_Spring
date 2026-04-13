package org.example.bai3_ss07.service;

import org.example.bai3_ss07.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private static final List<Food> foods = new ArrayList<>();
    private static Long currentId = 1L;

    public void addFood(Food food) {
        food.setId(currentId++);
        foods.add(food);
    }

    public List<Food> getAllFoods() {
        return foods;
    }

    public int getTotalFoods() {
        return foods.size();
    }
}