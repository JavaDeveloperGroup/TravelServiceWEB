package by.htp.travelserviceWEB.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encryption {
	
	public static String md5Apache(String password) {
	    String passwordHex = DigestUtils.md5Hex(password);
	    System.out.println(passwordHex);
	    return passwordHex;
	}

}
