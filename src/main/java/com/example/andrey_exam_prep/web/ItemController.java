package com.example.andrey_exam_prep.web;

import com.example.andrey_exam_prep.model.binding.ItemAddBindingModel;
import com.example.andrey_exam_prep.model.service.ItemServiceModel;
import com.example.andrey_exam_prep.model.view.ItemViewModel;
import com.example.andrey_exam_prep.service.ItemService;
import com.example.andrey_exam_prep.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final CurrentUser currentUser;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(CurrentUser currentUser, ItemService itemService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.itemService = itemService;
        this.modelMapper = modelMapper;

        ;
    }

    @GetMapping("/add")
    public String add() {
        if(currentUser.isAnonymous()) {
            return "redirect:/";
        }

        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }


        itemService.addItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));



        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detail(@PathVariable Long id, Model model) {
        if(currentUser.isAnonymous()) {
            return "redirect:/";
        }

        ItemViewModel itemViewModel = itemService.showDetails(id);
        model.addAttribute("itemViewModel" , itemViewModel);

        return "details-item";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Long id) {
        if(currentUser.isAnonymous()) {

            return "redirect:/";
        }

        itemService.deleteItem(id);
        return "redirect:/";
    }

    @ModelAttribute
    public ItemViewModel itemViewModel() {
        return new ItemViewModel();
    }


    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel() {
        return new ItemAddBindingModel();
    }
}
