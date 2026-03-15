package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Exercise;
import com.anaclarissi.health_diary.model.Meal;
import com.anaclarissi.health_diary.model.Sleep;
import com.anaclarissi.health_diary.service.ExerciseService;
import com.anaclarissi.health_diary.service.MealService;
import com.anaclarissi.health_diary.service.SleepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/crud")
public class CrudController {

    @Autowired
    private SleepService sleepService;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private MealService mealService;

    @GetMapping
    public String crud(Model model) {

        try {

            model.addAttribute("sleeps", sleepService.findAll());

            model.addAttribute("exercises", exerciseService.findAll());

            model.addAttribute("meals", mealService.findAll());

            model.addAttribute("sleep", new Sleep());

            model.addAttribute("exercise", new Exercise());

            model.addAttribute("meal", new Meal());

            return "crud";

        } catch (Exception e) {

            log.error(e.getMessage(), e);

            return "Error " + e.getMessage();

        }

    }

}
