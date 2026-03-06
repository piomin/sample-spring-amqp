package pl.piomin.services.amqp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerComponent {

	private static final Logger LOG = LoggerFactory.getLogger(ListenerComponent.class);

	@RabbitListener(bindings = {
		@QueueBinding(
			exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "trx-events-topic"),
			value = @Queue("${topic.queue.name}")
		)
	})
	public void onTopicMessage(SampleMessage message) {
		LOG.info("Message received: {}", message);
	}

	@RabbitListener(bindings = {
		@QueueBinding(
			exchange = @Exchange(type = ExchangeTypes.DIRECT, name = "trx-events-direct"),
			value = @Queue("${direct.queue.name}")
		)
	})
	public void onDirectMessage(SampleMessage message) {
		LOG.info("Message received: {}", message);
	}

}
