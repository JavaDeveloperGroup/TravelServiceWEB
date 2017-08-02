package by.htp.travelserviceWEB.util;

import org.apache.commons.codec.binary.Base64;

public class Encryption {
	
	public Encryption(){}
	
	public static String base64Code(String password) {
		byte[] binaryPassword = password.getBytes();
		String binaryData = Base64.encodeBase64String(binaryPassword);
	    return binaryData;
	}
//	public static String base64Decode(String binaryData) {
//		byte[] decoderData = Base64.decodeBase64(binaryData);
//		String pass = new String(decoderData);
//	    return pass;
//	}
}
