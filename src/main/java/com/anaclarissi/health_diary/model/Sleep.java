package com.anaclarissi.health_diary.model;

import com.anaclarissi.health_diary.model.enums.SleepQuality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tb_sleep")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime hoursSlept;

    @Enumerated(EnumType.STRING)
    private SleepQuality sleepQuality;

    private LocalDateTime registerDate;

}
