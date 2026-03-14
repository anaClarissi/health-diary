package com.anaclarissi.health_diary.service;

import com.anaclarissi.health_diary.model.Exercise;
import com.anaclarissi.health_diary.repository.ExerciseRepository;
import com.anaclarissi.health_diary.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcerciseService {

    @Autowired
    private ExerciseRepository repository;

    public List<Exercise> findAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            throw new RuntimeException("Exercise Service findAll Error -> " + e.getMessage());

        }

    }

    public Exercise findById(Long id) {

        Optional<Exercise> excercise = repository.findById(id);

        return excercise.orElseThrow(() ->  new RuntimeException("Exercise Service findById Error"));

    }

    public Exercise insert(Exercise exercise) {

        try {

            return repository.save(exercise);

        } catch (Exception e) {

            throw new RuntimeException("Exercise Service insert Error -> " + e.getMessage());

        }

    }

    public void deleteById(Long id) {

        try {

            repository.deleteById(id);

        } catch (Exception e) {

            throw new RuntimeException("Exercise Service deleteById Error -> " + e.getMessage());


        }

    }

    public Exercise update(Long id, Exercise exercise) {

        try {

            Exercise entity = repository.getReferenceById(id);

            updateDate(entity, exercise);

            return entity;

        } catch (Exception e) {

            throw new RuntimeException("Exercise Service findAll Error -> " + e.getMessage());

        }

    }

    private void updateDate(Exercise entity, Exercise exercise) {

        entity.setDate(exercise.getDate());

        entity.setName(exercise.getName());

        entity.setSeries(exercise.getSeries());

        entity.setRepetitions(exercise.getRepetitions());

        entity.setLoad(exercise.getLoad());

        entity.setTime(exercise.getTime());

    }

}
