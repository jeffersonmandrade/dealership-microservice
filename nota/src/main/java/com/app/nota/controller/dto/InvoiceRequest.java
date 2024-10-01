package com.app.nota.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceRequest {
    private Long id;
    private String dealershipName;
    private String buyerName;
    private String carModel;
    private String carBrand;
    private BigDecimal totalAmount;
    private String paymentMethod;
}
