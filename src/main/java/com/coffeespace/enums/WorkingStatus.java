package com.coffeespace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkingStatus {
    ALREADY_FULL_TIME("Already full-time on a startup"),
    READY_WITH_COFUNDER("Ready to go full-time with the right co-founder"),
    READY_NEXT_YEAR("Ready to go full-time in the next year"),
    NO_SPECIFIC_PLANS("No specific startup plans yet");

    private final String value;
}
