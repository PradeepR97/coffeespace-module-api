package com.coffeespace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Skill {
    AI_ML("AI/ML"),
    DESIGN("Design"),
    ENGINEERING("Engineering"),
    OPERATIONS("Operations"),
    PRODUCT("Product"),
    SALES_MARKETING("Sales / Marketing");

    private final String value;
}
