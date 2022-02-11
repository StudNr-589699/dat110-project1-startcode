package no.hvl.dat110.messaging;

import java.util.Arrays;
import java.util.Iterator;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

        byte[] segment = null;
        byte[] data;

        // TODO - START
        data = message.getData();
        int size = data.length;

        // encapsulate/encode the payload data of the message and form a segment
        // according to the segment format for the messagin layer
        segment = new byte[SEGMENTSIZE];
        segment[0] = (byte) size;

        //Adding the data to the message segment
        int i;
        for (i=0; i<data.length; i++) {
            segment[i+1] = data[i];
        }

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
