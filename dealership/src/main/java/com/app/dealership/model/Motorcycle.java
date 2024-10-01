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
public class Motorcycle {
    private Long id;
    private String type;
    private Long engineCapacity;
    private String startType;
    private double kilometersDriven;
    private boolean isUsed;
    private boolean abs;
    private Long topSpeed;
    private BigDecimal price;
}

