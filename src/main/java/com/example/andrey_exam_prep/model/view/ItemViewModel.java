package com.example.andrey_exam_prep.model.view;

import com.example.andrey_exam_prep.model.entity.CategoryEnum;

import javax.persistence.Column;
import java.math.BigDecimal;

public class ItemViewModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String gender;
    private String imgUrl;
    private CategoryEnum category;


    public ItemViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemViewModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ItemViewModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ItemViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
