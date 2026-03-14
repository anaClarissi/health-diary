package com.anaclarissi.health_diary.service;

import com.anaclarissi.health_diary.model.Sleep;
import com.anaclarissi.health_diary.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SleepService {

    @Autowired
    private SleepRepository repository;

    public List<Sleep> findAll() {

        try {

            return repository.findAll();

        } catch (Exception e) {

            throw new RuntimeException("Sleep Service findAll Error -> " + e.getMessage());

        }

    }

    public Sleep findById(Long id) {

        Optional<Sleep> sleep = repository.findById(id);

        return sleep.orElseThrow(() -> new RuntimeException("Sleep Service findById Error"));

    }

    public Sleep insert(Sleep sleep) {


        try {

            return repository.save(sleep);

        } catch (Exception e) {

            throw new RuntimeException("Sleep Service insert Error -> " + e.getMessage());

        }

    }

    public void deleteById(Long id) {

        try {

            repository.deleteById(id);

        } catch (Exception e) {

            throw new RuntimeException("Sleep Service deleteById Error -> " + e.getMessage());

        }

    }

    public Sleep update(Long id, Sleep sleep) {

        try {

            Sleep entity = repository.getReferenceById(id);

            updateDate(entity, sleep);

            return entity;

        } catch (Exception e) {

            throw new RuntimeException("Sleep Service update Error -> " + e.getMessage());

        }

    }

    private void updateDate(Sleep entity, Sleep sleep) {

        entity.setHoursSlept(sleep.getHoursSlept());

        entity.setSleepQuality(sleep.getSleepQuality());

        entity.setRegisterDate(sleep.getRegisterDate());

    }

}
