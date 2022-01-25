package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private int maxBytes = 127;

	private byte[] data;
/**
 *  hallaien
 * @param Implementing constructor og lagde en sjekk. task1. message.java
 */
	public Message(byte[] data) {
		this.data = data;

		if (data != null && data.length <= maxBytes) {

			if (true)
				throw new UnsupportedOperationException(TODO.constructor("Message"));
		}

	}

	public byte[] getData() {
		return this.data;
	}

}
