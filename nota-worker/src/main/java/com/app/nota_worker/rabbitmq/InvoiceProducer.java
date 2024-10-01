package com.app.nota_worker.rabbitmq;

import com.app.nota_worker.model.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void send(Invoice invoice) throws JsonProcessingException {
        amqpTemplate.convertAndSend("nota-fiscal-ok.exc", "nota-fiscal-ok.rk",
                objectMapper.writeValueAsString(invoice));
    }
}
