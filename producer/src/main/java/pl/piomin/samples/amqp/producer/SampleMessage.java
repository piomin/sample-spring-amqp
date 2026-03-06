package pl.piomin.samples.amqp.producer;

import java.util.Objects;

public class SampleMessage {

	public SampleMessage() {
	}

	public SampleMessage(Integer id, String message, String type) {
		this.id = id;
		this.message = message;
		this.type = type;
	}

	private Integer id;
	private String message;
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		SampleMessage that = (SampleMessage) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "SampleMessage{" +
				"id=" + id +
				", message='" + message + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
