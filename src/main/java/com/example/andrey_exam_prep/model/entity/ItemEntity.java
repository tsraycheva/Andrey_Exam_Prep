package com.example.andrey_exam_prep.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class ItemEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private BigDecimal price;
    @ManyToOne
    private CategoryEntity category;
    private String gender;

    public ItemEntity() {
    }

    public String getName() {
        return name;
    }

    public ItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ItemEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
