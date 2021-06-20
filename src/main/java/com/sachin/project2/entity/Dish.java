package com.sachin.project2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String type;
    private String cuisine;
    private String description;


    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", description='" + description + '\'' +
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

    public Dish(int id, String title, String type, String cuisine, String description) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.cuisine = cuisine;
        this.description = description;
    }

    public Dish() {
    }
}
