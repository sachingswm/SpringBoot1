package com.sachin.project2.beans;

import com.sachin.project2.entity.Ingredient;

import java.util.List;

public class Response_Dish {
    private int id;
    private String title;
    private String type;
    private String cuisine;
    private String description;
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "Response_Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Response_Dish(int id, String title, String type, String cuisine, String description, List<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.cuisine = cuisine;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Response_Dish() {
    }
}
