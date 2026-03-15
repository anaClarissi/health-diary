package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Sleep;
import com.anaclarissi.health_diary.service.SleepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/sleep")
public class SleepController {

    @Autowired
    private SleepService service;

    @GetMapping(value = "/list")
    public String list(Model model) {

        model.addAttribute("sleeps", service.findAll());

        model.addAttribute("sleep", new Sleep());

        return "crud";

    }

    @PostMapping(value = "/save")
    public String insert(@ModelAttribute Sleep sleep) {

        service.insert(sleep);

        return "redirect:/crud";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteById(id);

        return "redirect:/crud";

    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Sleep sleep = service.findById(id);

        model.addAttribute("sleep", sleep);

        return "crud";

    }

    @PostMapping(value = "/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Sleep sleep) {

        service.update(id, sleep);

        return "redirect:/crud";

    }

}
