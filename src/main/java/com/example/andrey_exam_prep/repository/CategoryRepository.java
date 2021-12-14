package com.example.andrey_exam_prep.repository;

import com.example.andrey_exam_prep.model.entity.CategoryEntity;
import com.example.andrey_exam_prep.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {


    CategoryEntity findCategoryEntityByName(CategoryEnum categoryEnum);
}
