package com.app.nota_worker.rabbitmq;

import com.app.nota_worker.model.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceConsumer {

    private final InvoiceProducer invoiceProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = {"nota-fiscal-queue"})
    public void process(@Payload String message)  {
        Invoice invoice = objectMapper.convertValue(message, Invoice.class);
        log.info("Received message: {}", message);
        try {
            invoiceProducer.send(invoice);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
