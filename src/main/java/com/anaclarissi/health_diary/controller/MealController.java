package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Meal;
import com.anaclarissi.health_diary.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/meal")
public class MealController {

    @Autowired
    private MealService service;

    @GetMapping
    public ResponseEntity<List<Meal>> findAll() {

        List<Meal> list = service.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Meal> findById(@PathVariable Long id) {

        Meal meal = service.findById(id);

        return ResponseEntity.ok().body(meal);

    }

    @PostMapping
    public ResponseEntity<Meal> insert(@RequestBody Meal meal) {

        meal = service.insert(meal);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(meal.getId()).toUri();

        return ResponseEntity.created(uri).body(meal);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Meal> update(@PathVariable Long id, @RequestBody Meal meal) {

        meal = service.upadate(id, meal);

        return ResponseEntity.ok().body(meal);

    }

}
