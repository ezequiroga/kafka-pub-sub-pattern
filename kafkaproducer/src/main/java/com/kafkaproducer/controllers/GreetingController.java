package com.kafkaproducer.controllers;

import com.kafkaproducer.dtos.GreetingDto;
import com.kafkaproducer.services.KafkaProducerPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eze Q.
 * @version
 * @since
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private KafkaProducerPublisher publisher;
    
    @PostMapping
    public ResponseEntity msgToKafka(@RequestBody GreetingDto greetingDto){
        publisher.sendMessage(greetingDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
}
