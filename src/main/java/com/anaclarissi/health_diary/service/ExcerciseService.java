package com.anaclarissi.health_diary.service;

import com.anaclarissi.health_diary.model.Excercise;
import com.anaclarissi.health_diary.repository.ExcerciseRepository;
import com.anaclarissi.health_diary.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcerciseService {

    @Autowired
    private ExcerciseRepository repository;

    public List<Excercise> findAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            throw new RuntimeException("Excercise Service findAll Error -> " + e.getMessage());

        }

    }

    public Excercise findById(Long id) {

        Optional<Excercise> excercise = repository.findById(id);

        return excercise.orElseThrow(() ->  new RuntimeException("Excercise Service findById Error"));

    }

    public Excercise insert(Excercise excercise) {

        try {

            return repository.save(excercise);

        } catch (Exception e) {

            throw new RuntimeException("Excercise Service insert Error -> " + e.getMessage());

        }

    }

    public void deleteById(Long id) {

        try {

            repository.deleteById(id);

        } catch (Exception e) {

            throw new RuntimeException("Excercise Service deleteById Error -> " + e.getMessage());


        }

    }

    public Excercise update(Long id, Excercise excercise) {

        Excercise entity = repository.getReferenceById(id);

        Util.updateData(entity, excercise);

        return entity;

    }

}
