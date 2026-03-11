package com.anaclarissi.health_diary.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SleepQuality {

    VERY_BAD(1, "very bad sleep"),
    BAD(2, "bad Sleep"),
    MODERATE(3, "moderate sleep"),
    GOOD(4, "good sleep"),
    VERY_GOOD(5, "very good sleep");

    private final Integer quality;

    private final String description;

}
