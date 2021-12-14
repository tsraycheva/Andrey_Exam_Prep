package com.example.andrey_exam_prep.service;

import com.example.andrey_exam_prep.model.binding.ItemAddBindingModel;
import com.example.andrey_exam_prep.model.service.ItemServiceModel;
import com.example.andrey_exam_prep.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel showDetails(Long id);

    void deleteItem(Long id);
}
