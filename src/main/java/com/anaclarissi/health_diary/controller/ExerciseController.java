package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Exercise;
import com.anaclarissi.health_diary.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping(value = "/list")
    public String list(Model model) {

        model.addAttribute("exercises", service.findAll());

        model.addAttribute("exercise", new Exercise());

        return "crud";

    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Exercise exercise) {

        service.insert(exercise);

        return "redirect:/crud";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteById(id);

        return "redirect:/crud";

    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Exercise exercise = service.findById(id);

        model.addAttribute("exercise", exercise);

        return "crud";

    }

    @PostMapping(value = "/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Exercise exercise) {

        service.update(id, exercise);

        return "redirect:/crud";

    }

}
