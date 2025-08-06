package com.coffeespace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExperienceType {
    SOLD_STARTUP("Sold a startup"),
    FOUNDED_OR_COF_OUNDED_COMPANY("Founded/cofounded a company"),
    WORKED_IN_STARTUP("Worked in a startup"),
    NO_EXPERIENCE("No prior startup experience");

    private final String value;
}
