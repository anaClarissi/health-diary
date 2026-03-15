package com.anaclarissi.health_diary.model;

import com.anaclarissi.health_diary.model.enums.SleepQuality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_sleep")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hoursSlept;

    @Enumerated(EnumType.STRING)
    private SleepQuality sleepQuality;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;

}
