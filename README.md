# Pub / Sub Architectural Pattern using Kafka

This is a simply project for implementing pub/sub pattern using Kafka running in containers.

## Structure

* **zookeeper**: it contains the Dockerfile and the environment.env for Zookeeper container.

* **kafka**: it contains the Dockerfile and the environment.env for Kafka container.

* **kafkaconector**: it contains a SpringBoot project that creates a topic to be used by the producer and consumer.

* **kafkaproducer**: it contains a SpringBoot project that creates messages on Kafka from incoming http request.

* **kafkaconsumer**: it contains a SpringBoot project that consume messages from Kafka and prints them.

SpringBoot projects have been created using [Spring Initializr](https://start.spring.io/).

## docker-compose
The *docker-compose.yaml* specifies all services' configurations.

For launch all containers just run
 `docker-compose up --build -d`.

## Sources
Kafka image from [bitnami/kafka](https://hub.docker.com/r/bitnami/kafka/).

Zookeeper image from [bitnami/zookeeper](https://hub.docker.com/r/bitnami/zookeeper/).

[Intro to Apache Kafka with Spring](https://www.baeldung.com/spring-kafka, "Baeldung").

[Using Kafka with Spring Boot](https://reflectoring.io/spring-boot-kafka/, "Reflectoring").

[Kafka - Introduction to Kafka Admin API](https://www.logicbig.com/tutorials/misc/kafka/admin-api-getting-started.html, "Logicbig").

[Spring Kafka The class is not in the trusted packages](https://www.logicbig.com/tutorials/misc/kafka/admin-api-getting-started.html, "Stackoverflow").
