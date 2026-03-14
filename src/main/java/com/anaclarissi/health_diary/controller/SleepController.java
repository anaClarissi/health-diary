package com.anaclarissi.health_diary.controller;

import com.anaclarissi.health_diary.model.Sleep;
import com.anaclarissi.health_diary.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sleep")
public class SleepController {

    @Autowired
    private SleepService service;

    @GetMapping
    public ResponseEntity<List<Sleep>> findAll() {

        List<Sleep> list = service.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sleep> findById(@PathVariable Long id) {

        Sleep sleep = service.findById(id);

        return ResponseEntity.ok().body(sleep);

    }

    @PostMapping
    public ResponseEntity<Sleep> insert(@RequestBody Sleep sleep) {

        sleep = service.insert(sleep);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sleep.getId()).toUri();

        return ResponseEntity.created(uri).body(sleep);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Sleep> update(@PathVariable Long id, @RequestBody Sleep sleep) {

        sleep = service.update(id, sleep);

        return ResponseEntity.ok().body(sleep);

    }

}
