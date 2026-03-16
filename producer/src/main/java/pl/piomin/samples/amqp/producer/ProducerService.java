package pl.piomin.samples.amqp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProducerService {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);

    AtomicInteger counter = new AtomicInteger();

    private final RabbitTemplate rabbitTemplate;

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String destination) {
        SampleMessage msg = new SampleMessage(counter.incrementAndGet(), "abc", "topic");
        rabbitTemplate.convertAndSend(destination, null, msg);
        LOG.info("Sending message: {}", msg);
    }
}
