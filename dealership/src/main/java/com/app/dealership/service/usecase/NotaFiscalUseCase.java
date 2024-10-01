package com.app.dealership.service.usecase;

import com.app.dealership.model.Invoice;
import com.app.dealership.service.client.NotaClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NotaFiscalUseCase {

    private final NotaClient notaClient;

    public void sendNota(Invoice invoice) {
        notaClient.createInvoice(invoice);
    }
}
