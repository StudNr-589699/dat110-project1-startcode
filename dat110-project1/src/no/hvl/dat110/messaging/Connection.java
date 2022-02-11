package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {
		
		
		byte[] data = MessageUtils.encapsulate(message);
		
		
		// TODO - START
		// encapsulate the data contained in the message and write to the output stream
		
		try {
			outStream.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		// TODO - END

	}

	public Message receive() {

		Message message = null;
//		byte[] dataLength = new byte[1];
//		byte[] payload = null;
//		byte[] data = null;
//		// TODO - START
//		
//		try {
//			inStream.read(dataLength);
//			payload = new byte[dataLength[0]];
//			inStream.read(payload);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		data = new byte[dataLength.length + payload.length];
//		
//		for (int i = 0; i < payload.length; i++) {
//			data[i + dataLength.length] = payload[i];
//		}
//		
//		data[0] = dataLength[0];
//		message = MessageUtils.decapsulate(data);
		
		byte[] m = new byte[128];
		
		try {
			inStream.read(m);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		message = MessageUtils.decapsulate(m);
		
		
		// TODO - END
		
		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}