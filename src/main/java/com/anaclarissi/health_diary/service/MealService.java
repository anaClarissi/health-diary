package com.anaclarissi.health_diary.service;

import com.anaclarissi.health_diary.model.Meal;
import com.anaclarissi.health_diary.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    public List<Meal> findAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            throw new RuntimeException("Meal Service findAll Error -> " + e.getMessage());

        }

    }

    public Meal findById(Long id) {

        Optional<Meal> meal = repository.findById(id);

        return meal.orElseThrow(() -> new RuntimeException("Meal Service findById Error"));

    }

    public Meal insert(Meal meal) {

        try {

            return repository.save(meal);

        } catch (Exception e) {

            throw new RuntimeException("Meal Service insert Error -> " + e.getMessage());

        }

    }

    public void deleteById(Long id) {

        try {

            repository.deleteById(id);

        } catch (Exception e) {

            throw new RuntimeException("Meal Service deleteById Error -> " + e.getMessage());

        }

    }

    @Transactional
    public Meal update(Long id, Meal meal) {

        try {

            Meal entity = repository.getReferenceById(id);

            updateDate(entity, meal);

            return entity;

        } catch (Exception e) {

            throw new RuntimeException("Meal Service update Error -> " + e.getMessage());

        }

    }

    private void updateDate(Meal entity, Meal meal) {

        entity.setType(meal.getType());

        entity.setDescription(meal.getDescription());

        entity.setQuantity(meal.getQuantity());

        entity.setType(meal.getType());

    }

}
