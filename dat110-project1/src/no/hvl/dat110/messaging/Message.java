package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	// setter bare max bytes
	private final int maxBytes = 128;
	private byte[] data;

	/**
	 * 
	 * @param Implementing constructor og lagde en sjekk. task1. message.java
	 */
	public Message(byte[] data) {
		if (data != null && data.length <= maxBytes) {
			this.data = data;
		}

	}

	public byte[] getData() {
		return this.data;
	}

}
