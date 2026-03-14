package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Excercise;
import com.anaclarissi.health_diary.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/excercise")
public class ExcerciseController {

    @Autowired
    private ExcerciseService service;

    @GetMapping
    public ResponseEntity<List<Excercise>> findAll() {

        List<Excercise> list = service.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Excercise> findById(@PathVariable Long id) {

        Excercise excercise = service.findById(id);

        return ResponseEntity.ok().body(excercise);

    }

    @PostMapping
    public ResponseEntity<Excercise> insert(@RequestBody Excercise excercise) {

        excercise = service.insert(excercise);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(excercise.getId()).toUri();

        return ResponseEntity.created(uri).body(excercise);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Excercise> update(@PathVariable Long id, @RequestBody Excercise excercise) {

        excercise = service.update(id, excercise);

        return ResponseEntity.ok().body(excercise);

    }

}
