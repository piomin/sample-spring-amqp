package pl.piomin.samples.amqp.producer;

import io.micrometer.core.instrument.Timer.Sample;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProducerComponent {

	int index = 1;
	private RabbitTemplate rabbitTemplate;

	ProducerComponent(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Scheduled(fixedRate = 5000)
	public void sendToTopic() {
		SampleMessage msg = new SampleMessage(index++, "abc", "topic");
		rabbitTemplate.convertAndSend("trx-events-topic", null, msg);
		log.info("Sending message: {}", msg);
	}

	@Scheduled(fixedRate = 2000)
	public void sendToDirect() {
		SampleMessage msg = new SampleMessage(index++, "abc", "direct");
		rabbitTemplate.convertAndSend("trx-events-direct", null, msg);
		log.info("Sending message: {}", msg);
	}
	
}
