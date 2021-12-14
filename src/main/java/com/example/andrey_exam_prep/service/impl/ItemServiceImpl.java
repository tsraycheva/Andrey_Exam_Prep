package com.example.andrey_exam_prep.service.impl;

import com.example.andrey_exam_prep.model.entity.ItemEntity;
import com.example.andrey_exam_prep.model.service.ItemServiceModel;
import com.example.andrey_exam_prep.model.view.ItemViewModel;
import com.example.andrey_exam_prep.repository.ItemRepository;
import com.example.andrey_exam_prep.service.CategoryService;
import com.example.andrey_exam_prep.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;

        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {


        ItemEntity itemEntity = modelMapper.map(itemServiceModel, ItemEntity.class);
        itemEntity.setCategory(categoryService.findByCategoryNameEnum(itemServiceModel.getCategoryEnum()));
        itemRepository.save(itemEntity);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository
                .findAll()
                .stream().map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper
                            .map(itemEntity, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            itemEntity.getGender(), itemEntity.getCategory().getName().name()));
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel showDetails(Long id) {
        return itemRepository
                .findById(id)
                .map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper.map(itemEntity, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            itemEntity.getGender(), itemEntity.getCategory().getName().name()));
                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
