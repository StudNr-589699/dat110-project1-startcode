package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START

		rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;
		for (int i = 0; i < payload.length; i++) {
			rpcmsg[i+1] = payload[i];
		}
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START

		payload = new byte[rpcmsg.length - 1];
		for (int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i + 1];
		}
		
		// TODO - END
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {

		byte[] encoded = null;
		
		// TODO - START 
		
		encoded = str.getBytes();
				
		// TODO - END
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {

		String decoded = null;
		
		// TODO - START 
		
		decoded = new String(data);
				
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		encoded = new byte[0];
				
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		
		return;
		
	}
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		encoded = bb.array();
		
		// TODO - END
		
		return encoded;
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.put(data);
		decoded = bb.getInt();
		
		// TODO - END
		
		return decoded;
		
	}
}
