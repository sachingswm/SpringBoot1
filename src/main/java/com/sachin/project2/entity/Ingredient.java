package com.sachin.project2.entity;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int dishId;

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishId=" + dishId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Ingredient(int id, String name, int dishId) {
        this.id = id;
        this.name = name;
        this.dishId = dishId;
    }

    public Ingredient() {
    }
}
