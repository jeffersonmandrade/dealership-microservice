package com.app.dealership.service.client;

import com.app.dealership.model.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTA-SERVICE")
public interface NotaClient {

    @PostMapping("/create/nota")
    ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoiceRequest);

}
