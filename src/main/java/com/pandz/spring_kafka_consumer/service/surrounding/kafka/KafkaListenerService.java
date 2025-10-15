package com.pandz.spring_kafka_consumer.service.surrounding.kafka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandz.spring_kafka_consumer.model.internal.CustomerInfo;
import com.pandz.spring_kafka_consumer.model.internal.KafkaBaseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.pandz.spring_kafka_consumer.constant.GeneralConstant.TOPIC_CUSTOMER;
import static com.pandz.spring_kafka_consumer.constant.GeneralConstant.TOPIC_GENERAL;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListenerService {
    @KafkaListener(topics = TOPIC_GENERAL, groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(String message) {
        try {
            log.info("Incoming Message: {}", message);
        } catch (Exception e) {
            log.error("error when listen message: {}", e.getMessage());
        }
    }

    TypeReference<KafkaBaseMessage<CustomerInfo>> typeRef = new TypeReference<KafkaBaseMessage<CustomerInfo>>() {};

    @KafkaListener(topics = TOPIC_CUSTOMER, groupId = "${spring.kafka.consumer.group-id}")
    public void listenCustomerMessage(String message) {
        try {
            log.info("Incoming Message: {}", message);
            KafkaBaseMessage<CustomerInfo> baseMessage = (new ObjectMapper()).readValue(message, typeRef);
            log.info("Result message: " + baseMessage);
            log.info("Customer: " + baseMessage.getData());
        } catch (Exception e) {
            log.error("error when listen message: {}", e.getMessage());
        }
    }
}
