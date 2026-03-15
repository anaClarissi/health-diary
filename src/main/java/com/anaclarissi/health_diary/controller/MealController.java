package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Meal;
import com.anaclarissi.health_diary.service.MealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/meal")
public class MealController {

    @Autowired
    private MealService service;

    @GetMapping(value = "/list")
    public String list(Model model) {

        model.addAttribute("meals", service.findAll());

        model.addAttribute("meal", new Meal());

        return "crud";

    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Meal meal) {

        service.insert(meal);

        return "redirect:/crud";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteById(id);

        return "redirect:/crud";

    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Meal meal = service.findById(id);

        model.addAttribute("meal", meal);

        return "crud";

    }

    @PostMapping(value = "/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Meal meal) {

        service.update(id, meal);

        return "redirect:/crud";

    }

}
