package pl.piomin.samples.amqp.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class ProducerService {

    AtomicInteger counter = new AtomicInteger();

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String destination) {
        SampleMessage msg = new SampleMessage(counter.incrementAndGet(), "abc", "topic");
        rabbitTemplate.convertAndSend(destination, null, msg);
        log.info("Sending message: {}", msg);
    }
}
