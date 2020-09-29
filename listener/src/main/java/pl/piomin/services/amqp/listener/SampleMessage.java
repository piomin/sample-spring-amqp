package pl.piomin.services.amqp.listener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SampleMessage {
	private Integer id;
	private String message;
	private String type;
}
