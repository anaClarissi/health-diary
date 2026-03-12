package com.anaclarissi.health_diary.repository;

import com.anaclarissi.health_diary.model.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepRepository extends JpaRepository<Sleep, Long> {
}
