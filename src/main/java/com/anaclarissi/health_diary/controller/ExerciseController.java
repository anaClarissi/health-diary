package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Exercise;
import com.anaclarissi.health_diary.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/excercise")
public class ExerciseController {

    @Autowired
    private ExcerciseService service;

    @GetMapping
    public ResponseEntity<List<Exercise>> findAll() {

        List<Exercise> list = service.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exercise> findById(@PathVariable Long id) {

        Exercise exercise = service.findById(id);

        return ResponseEntity.ok().body(exercise);

    }

    @PostMapping
    public ResponseEntity<Exercise> insert(@RequestBody Exercise exercise) {

        exercise = service.insert(exercise);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exercise.getId()).toUri();

        return ResponseEntity.created(uri).body(exercise);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exercise> update(@PathVariable Long id, @RequestBody Exercise exercise) {

        exercise = service.update(id, exercise);

        return ResponseEntity.ok().body(exercise);

    }

}
