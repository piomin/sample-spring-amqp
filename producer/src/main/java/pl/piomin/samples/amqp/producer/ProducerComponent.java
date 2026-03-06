package pl.piomin.samples.amqp.producer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProducerComponent {

	private final ProducerService service;

	public ProducerComponent(ProducerService service) {
		this.service = service;
	}

	@Scheduled(fixedRate = 5000)
	public void sendToTopic() {
		service.send("trx-events-topic");
	}

	@Scheduled(fixedRate = 2000)
	public void sendToDirect() {
		service.send("trx-events-direct");
	}
	
}
