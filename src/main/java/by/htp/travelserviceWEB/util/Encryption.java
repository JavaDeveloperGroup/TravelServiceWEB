package by.htp.travelserviceWEB.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encryption {
	
	public static String md5Apache(String password) {
	    return DigestUtils.md5Hex(password);
	}

}
