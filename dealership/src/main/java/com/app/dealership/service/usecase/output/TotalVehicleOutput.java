package com.app.dealership.service.usecase.output;


import java.math.BigDecimal;

public record TotalVehicleOutput(
        BigDecimal totalValue,
        int vehicleCount
) {}