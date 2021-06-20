package com.sachin.project2.dao;

import com.sachin.project2.entity.Dish;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishDao extends CrudRepository<Dish,Integer> {
    @Query(value = "select * from dish where type = ?1",nativeQuery = true)
    public List<Dish> getDishesByType(String type);

    @Query(value = "select distinct (dish.id),dish.title,dish.type,dish.cuisine,dish.description from ingredient inner join dish on ingredient.dish_id=dish.id where ingredient.name=?1",nativeQuery = true)
    public List<Dish> getDishesByKeyIngredient(String ingredient);

    @Query(value = "update dish set  title=?1,type=?2,cuisine=?3,description=?4 where id=?5",nativeQuery = true)
    @Modifying
    public void modifyDish(String title,String type,String cuisine,String description,int id);

    @Query(value="CALL delete_func2(?1)",nativeQuery = true)
    @Modifying
    public void deleteByid(int id);

}
