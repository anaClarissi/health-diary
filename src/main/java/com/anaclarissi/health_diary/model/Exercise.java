package com.anaclarissi.health_diary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_exercise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String name;
    private Integer series;
    private Integer repetitions;
    private Double load;
    private LocalTime time;


}
