package no.hvl.dat110.messaging;

import java.util.Arrays;
import java.util.Iterator;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

		
		
		

		// TODO - START
			
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		
		segment[0] = (byte) data.length;
		
		for (int i = 0; i < data.length; i++) {
			segment[i + 1] = data[i];
		}
		
		
		
		

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin' layer

		

		// TODO - END
		return segment;

	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		
		

		// TODO - START
		// decapsulate segment and put received data into a message
		
		byte[] data = new byte[segment[0]];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = segment[i + 1];
		}
		
		
		message = new Message(data);
		

		

		// TODO - END

		return message;

	}

}
