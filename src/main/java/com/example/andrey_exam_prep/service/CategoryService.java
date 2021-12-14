package com.example.andrey_exam_prep.service;

import com.example.andrey_exam_prep.model.entity.CategoryEntity;
import com.example.andrey_exam_prep.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryEnum category);
}
