package com.sachin.project2.service;

import com.sachin.project2.beans.Response_Dish;
import com.sachin.project2.dao.DishDao;
import com.sachin.project2.dao.IngredientDao;
import com.sachin.project2.entity.Dish;
import com.sachin.project2.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DishService {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private IngredientDao ingredientDao;
    public Dish addDish(Response_Dish responseDish)
    {
        Dish temp = new Dish();

        temp.setTitle(responseDish.getTitle());
        temp.setType(responseDish.getType());
        temp.setCuisine(responseDish.getCuisine());
        temp.setDescription(responseDish.getDescription());
        return addDish(temp,responseDish.getIngredients());
    }
    public Dish addDish(Dish dish, List<Ingredient> ingredients)
    {
        Dish temp = dishDao.save(dish);
        for (Ingredient ingredient:ingredients) {
            ingredient.setDishId(temp.getId());
            ingredientDao.save(ingredient);
        }
        return temp;
    }


    public void deleteDish(int id)
    {
        dishDao.deleteByid(id);
    }
    public void modifyDish(Dish newDish)
    {
        dishDao.modifyDish(newDish.getTitle(),newDish.getType(),newDish.getCuisine(),newDish.getDescription(),newDish.getId());
    }
    public Response_Dish getDishById(int id)
    {
        Dish temp=dishDao.findById(id).get();
        List<Ingredient> tempList=ingredientDao.getByDishId(temp.getId());
        Response_Dish response = new Response_Dish();
        response.setId(temp.getId());
        response.setTitle(temp.getTitle());
        response.setCuisine(temp.getCuisine());
        response.setDescription(temp.getDescription());
        response.setIngredients(tempList);
        return response;
    }
    public List<Response_Dish> getDishesByType(String type)
    {
        List<Response_Dish> response_dishes=new ArrayList<>();
        List<Dish> dishes=dishDao.getDishesByType(type);
        for(Dish temp:dishes)
        {
            List<Ingredient> tempList=ingredientDao.getByDishId(temp.getId());
            Response_Dish response_dish=new Response_Dish();
            Response_Dish response = new Response_Dish();
            response.setId(temp.getId());
            response.setTitle(temp.getTitle());
            response.setCuisine(temp.getCuisine());
            response.setDescription(temp.getDescription());
            response.setIngredients(tempList);
            response_dishes.add(response_dish);
        }
        return response_dishes;
    }
    public List<Dish> getDishesByIngredient(String ingredient)
    {
        return dishDao.getDishesByKeyIngredient(ingredient);
    }
}
