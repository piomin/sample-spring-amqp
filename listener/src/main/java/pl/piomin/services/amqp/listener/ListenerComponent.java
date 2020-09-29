package pl.piomin.services.amqp.listener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ListenerComponent {

	@RabbitListener(bindings = {
		@QueueBinding(
			exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "trx-events-topic"),
			value = @Queue("${topic.queue.name}")
		)
	})
	public void onTopicMessage(SampleMessage message) {
		log.info("Message received: {}", message);
	}

	@RabbitListener(bindings = {
		@QueueBinding(
			exchange = @Exchange(type = ExchangeTypes.DIRECT, name = "trx-events-direct"),
			value = @Queue("${direct.queue.name}")
		)
	})
	public void onDirectMessage(SampleMessage message) {
		log.info("Message received: {}", message);
	}

}
