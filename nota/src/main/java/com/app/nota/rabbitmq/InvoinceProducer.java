package com.app.nota.rabbitmq;

import com.app.nota.domain.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoinceProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void sendInvoice(Invoice invoice) throws JsonProcessingException {
        amqpTemplate.convertAndSend("nota-fiscal-exc","nota-fiscal-rk" , objectMapper.writeValueAsString(invoice));
    }



}
