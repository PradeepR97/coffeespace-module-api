package com.coffeespace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
    private String message;
    private int statusCode;
    private boolean success;
    private T data;
}
