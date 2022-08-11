package com.example.week02_day05_e_rahafalammar;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private int code;
}
