package com.example.andrey_exam_prep.service.impl;

import com.example.andrey_exam_prep.model.entity.CategoryEntity;
import com.example.andrey_exam_prep.model.entity.CategoryEnum;
import com.example.andrey_exam_prep.repository.CategoryRepository;
import com.example.andrey_exam_prep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        CategoryEntity category = new CategoryEntity();
                        category.setName(categoryEnum);
                        categoryRepository.save(category);
                    });

        }
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryEnum category) {
        return categoryRepository.findCategoryEntityByName(category);
    }


}
