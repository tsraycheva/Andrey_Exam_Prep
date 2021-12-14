package com.example.andrey_exam_prep.model.binding;

import com.example.andrey_exam_prep.model.entity.CategoryEntity;
import com.example.andrey_exam_prep.model.entity.CategoryEnum;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlMimeType;
import java.math.BigDecimal;

public class ItemAddBindingModel {


    @NotBlank(message = "You must enter you name of the product!")
    @Size(min=2, message = "Product name must be more than two characters!")
    private String name;
    @NotBlank(message = "Please enter some description!")
    @Size(min=3, message = "Product name must be more than two characters!")
    private String description;
    @Positive(message = "Price must be positive number!")
    private BigDecimal price;
    @NotNull(message = "You must select category of the product!")
    private CategoryEnum categoryEnum;
    @NotNull(message = "Please select gender!")
    private String gender;

    public ItemAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public ItemAddBindingModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
