package com.sachin.project2.controller;

import com.sachin.project2.beans.Response_Dish;
import com.sachin.project2.entity.Dish;
import com.sachin.project2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping("/addDish")
    public Dish addDish(@RequestBody Response_Dish request)
    {
        return dishService.addDish(request);
    }

    @DeleteMapping("/deleteDish/{id}")
    public void deleteDish(@PathVariable("id")int id)
    {
        dishService.deleteDish(id);
    }

    @PutMapping("/modifyDish")
    public void modifyDish(@RequestBody Dish dish)
    {
        dishService.modifyDish(dish);
    }

    @GetMapping("/getDishByType/{type}")
    public List<Response_Dish> getDishesByType(@PathVariable("type") String type)
    {
        return dishService.getDishesByType(type);
    }

    @GetMapping("/getDishByIngredient/{ingredient}")
    public List<Dish> getDishById(@PathVariable("ingredient")String ingredient)
    {
        return dishService.getDishesByIngredient(ingredient);
    }
}
