package com.anaclarissi.health_diary.repository;

import com.anaclarissi.health_diary.model.Excercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcerciseRepository extends JpaRepository<Excercise, Long> {
}
