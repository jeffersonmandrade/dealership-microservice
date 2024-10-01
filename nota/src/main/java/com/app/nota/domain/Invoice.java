package com.app.nota.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {
    private Long id;
    private String dealershipName;
    private String buyerName;
    private String carModel;
    private String carBrand;
    private BigDecimal totalAmount;
    private String paymentMethod;
}
