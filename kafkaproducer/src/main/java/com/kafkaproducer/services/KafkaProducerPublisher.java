package com.kafkaproducer.services;

import com.kafkaproducer.dtos.GreetingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author Eze Q.
 * @version
 * @since
 */
@Service
public class KafkaProducerPublisher {

    @Autowired
    private KafkaTemplate<String, GreetingDto> kafkaTemplate;

    private final String topicName = "firsttopic";

    public void sendMessage(GreetingDto greetingDto) {
        kafkaTemplate.send(topicName, greetingDto);
    }

    public void sendMessageBlocking(GreetingDto greetingDto) {
        Message<GreetingDto> message = MessageBuilder
                .withPayload(greetingDto)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        ListenableFuture<SendResult<String, GreetingDto>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, GreetingDto>>() {

            @Override
            public void onSuccess(SendResult<String, GreetingDto> result) {
                System.out.println("Sent message=[" + greetingDto.getName()
                        + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + greetingDto.getName() + "] due to : " + ex.getMessage());
            }
        });
    }

}
