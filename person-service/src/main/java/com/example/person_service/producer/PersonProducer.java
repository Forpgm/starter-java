package com.example.person_service.producer;

import com.example.person_service.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPersonUpdate(Person person) {
        kafkaTemplate.send("person-updates", person);
    }
}
