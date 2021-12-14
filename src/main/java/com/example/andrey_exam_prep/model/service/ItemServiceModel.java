package com.example.andrey_exam_prep.model.service;

import com.example.andrey_exam_prep.model.entity.CategoryEntity;
import com.example.andrey_exam_prep.model.entity.CategoryEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryEnum categoryEnum;
    private String gender;

    public ItemServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemServiceModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
