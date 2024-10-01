package com.app.nota.service;

import com.app.nota.domain.Invoice;
import com.app.nota.rabbitmq.InvoinceProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoinceProducer invoiceProducer;
    public void send(Invoice invoice) throws JsonProcessingException {
        invoiceProducer.sendInvoice(invoice)
        ;
    }
}
