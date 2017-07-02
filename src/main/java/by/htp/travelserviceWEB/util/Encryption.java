package by.htp.travelserviceWEB.util;

import org.apache.commons.codec.binary.Base64;

public class Encryption {
	
	public static String md5Apache(String password) {
		byte[] binaryPassword = password.getBytes();
		String binaryData = Base64.encodeBase64String(binaryPassword);
		//byte[] decoderData = Base64.decodeBase64(binaryData);
		//String pass = new String(decoderData);
	    return binaryData;
	}
}
