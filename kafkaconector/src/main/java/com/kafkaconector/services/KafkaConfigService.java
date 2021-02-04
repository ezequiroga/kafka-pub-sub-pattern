package com.kafkaconector.services;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eze Q.
 * @version
 * @since
 */
@Service
public class KafkaConfigService {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Autowired
    private KafkaAdmin kafkaAdmin;

    @PostConstruct
    public void config() {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        AdminClient admin = AdminClient.create(config);
        //creating new topic
        System.out.println("-- creating --");
        NewTopic newTopic = new NewTopic("firsttopic", 1, (short) 1);
        admin.createTopics(Collections.singleton(newTopic));

        //listing
        System.out.println("-- listing --");
        try {
            admin.listTopics().names().get().forEach(System.out::println);
        } catch (InterruptedException ex) {
            System.out.println("-- InterruptedException --");
            Logger.getLogger(KafkaConfigService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            System.out.println("-- ExecutionException --");
            Logger.getLogger(KafkaConfigService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
