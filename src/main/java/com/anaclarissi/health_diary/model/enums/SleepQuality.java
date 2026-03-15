package com.anaclarissi.health_diary.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SleepQuality {

    VERY_BAD(1, "muito ruim"),
    BAD(2, "ruim"),
    MODERATE(3, "moderado"),
    GOOD(4, "bom"),
    VERY_GOOD(5, "muito bom");

    private final Integer quality;

    private final String description;

}
