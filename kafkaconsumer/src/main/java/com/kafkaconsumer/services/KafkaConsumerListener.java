package com.kafkaconsumer.services;

import com.kafkaconsumer.dtos.GreetingDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eze Q.
 * @version v1.0.1
 * @since v1.0.1
 */
@Component
public class KafkaConsumerListener {
    
    private final String topicName = "firsttopic";
    private final String groupID = "firstgroup";

    @KafkaListener(topics = topicName, groupId = groupID, containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(GreetingDto greetingDto) {
        System.out.println("Received Message in group firstgroup: " + greetingDto.getName() + " - " + greetingDto.getMsg());
    }

}
