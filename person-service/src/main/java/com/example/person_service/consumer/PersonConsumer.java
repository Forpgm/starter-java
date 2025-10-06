package com.example.person_service.consumer;

import com.example.person_service.entity.Person;
import com.example.person_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "person-updates", groupId = "person-service")
public class PersonConsumer {

    @Autowired
    private PersonRepository personRepository;

    @KafkaHandler
    public void consumePersonUpdate(Person person) {
        personRepository.save(person);
    }
}

