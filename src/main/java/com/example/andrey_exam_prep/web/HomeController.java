package com.example.andrey_exam_prep.web;

import com.example.andrey_exam_prep.model.view.ItemViewModel;
import com.example.andrey_exam_prep.service.ItemService;
import com.example.andrey_exam_prep.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ItemService itemService;

    public HomeController(CurrentUser currentUser, ItemService itemService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if(currentUser.isAnonymous()) {
            return "index";
        }

        List<ItemViewModel> items = itemService.findAllItems();

        model.addAttribute("items", items);
        model.addAttribute("totalItems", items.size());
        return "home";
    }
}
