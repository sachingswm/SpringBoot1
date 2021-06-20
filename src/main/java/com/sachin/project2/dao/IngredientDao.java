package com.sachin.project2.dao;

import com.sachin.project2.entity.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao extends CrudRepository<Ingredient,Integer> {
    @Query(value = "delete from ingredient where dishId= ?1",nativeQuery = true)
    @Modifying
    public void deleteByDishId(int id);

    @Query(value="select * from ingredient where dishId=?1",nativeQuery = true)
    public List<Ingredient> getByDishId(int dishId);
}
