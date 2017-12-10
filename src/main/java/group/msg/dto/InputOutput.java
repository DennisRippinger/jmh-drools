package group.msg.dto;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class InputOutput {

	public InputOutput() {
		input = ThreadLocalRandom.current().nextInt(7);
	}

	public InputOutput(Integer input) {
		this.input = input;
	}

	private Integer input;

	private Integer output;

}
