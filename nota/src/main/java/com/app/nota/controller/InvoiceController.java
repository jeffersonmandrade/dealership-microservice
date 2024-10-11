package com.app.nota.controller;

import com.app.nota.controller.dto.InvoiceRequest;
import com.app.nota.domain.Invoice;
import com.app.nota.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Operation(summary = "Criar uma nova nota fiscal")
    @ApiResponse(responseCode = "201", description = "Nota fiscal criada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro ao processar a nota fiscal")
    @PostMapping("create/nota")
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        Invoice invoice = new Invoice(
                invoiceRequest.getId(),
                invoiceRequest.getDealershipName(),
                invoiceRequest.getBuyerName(),
                invoiceRequest.getCarModel(),
                invoiceRequest.getCarBrand(),
                invoiceRequest.getTotalAmount(),
                invoiceRequest.getPaymentMethod()
        );

        try {
            invoiceService.send(invoice);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }
}
