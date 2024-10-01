package com.app.dealership.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isUsed;
    private int mileage;
    private BigDecimal price;
}
