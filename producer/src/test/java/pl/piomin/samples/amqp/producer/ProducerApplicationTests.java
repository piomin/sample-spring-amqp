package pl.piomin.samples.amqp.producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class ProducerApplicationTests {

    @Bean
    public Queue queue() {
        return new Queue("trx-events-topic");
    }

    @Autowired
    ProducerService service;

    @Container
    static final RabbitMQContainer rabbitmq = new RabbitMQContainer("rabbitmq:latest")
            .withExposedPorts(5672);

    @DynamicPropertySource
    static void rabbitProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.rabbitmq.host", rabbitmq::getHost);
        registry.add("spring.rabbitmq.port", rabbitmq::getAmqpPort);
    }

    @Test
    void startup() {
        service.send("trx-events-topic");
    }
}
