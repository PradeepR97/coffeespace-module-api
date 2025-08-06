package com.coffeespace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Goal {
    LOOKING_FOR_COFUNDER("Looking for Co founder to join existing idea"),
    HAVE_IDEAS_OPEN_TO_EXPLORING("Have Some ideas but open to exploring"),
    EXPLORING_NEW_IDEAS("Exploring new ideas");

    private final String value;
}
