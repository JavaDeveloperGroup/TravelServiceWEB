package by.htp.travelserviceWEB.util;

public class EncryptionFdl{
	
	private EncryptionFdl(){}
	
	private static final String KEY = "fiDeliO";
	private static Integer dataLength = null;
	
	private static int[] dataInArrayInt(String data) {
		char[] dataArrayChar = data.toCharArray();
		dataLength = dataArrayChar.length;
		int[] dataArrayInt = new int[dataLength];
		for(int i = 0; i < dataLength; i++) {
			dataArrayInt[i] = dataArrayChar[i];
		}
		return dataArrayInt;
	}
	
	private static int[] keyArrayInt() {
		char[] keyArray = KEY.toCharArray();
		int lengthArrayKey = keyArray.length;
		char[] keyArrayChar = new char[dataLength];
		for(int i = 0; i < dataLength - 1; i++) {
			for(int k = 0, j = lengthArrayKey < dataLength ? dataLength : lengthArrayKey; k + i < j; k++) {
				keyArrayChar[i + k] = keyArray[k];
				if(k == (lengthArrayKey > dataLength ? dataLength : lengthArrayKey) - 1) {
					i = k + i;
					k = 0;
					break;
				}
			}
		}
		int[] keyArrayInt = new int[dataLength];
		for(int i = 0, l = dataLength; i < l; i++) {
			keyArrayInt[i] = keyArrayChar[i];
		}
		return keyArrayInt;
	}
	
	private static String getEncryptData(int[] dataArrayInt, int[] keyArrayInt) {
		char[] dataEncryptArrayChar = new char[dataLength];
		for(int i = 0; i < dataLength; i++) {
			dataEncryptArrayChar[i] = (char) (dataArrayInt[i] + keyArrayInt[i]);
		}
		return new String(dataEncryptArrayChar);
		
	}
	
	private static String getDecryptData(int[] dataArrayInt, int[] keyArrayInt) {
		char[] dataDecryptArrayChar = new char[dataArrayInt.length];
		for(int i = 0, l = dataArrayInt.length; i < l; i++) {
			dataDecryptArrayChar[i] = (char) (dataArrayInt[i] - keyArrayInt[i]);
		}
		return new String(dataDecryptArrayChar);
	}
	
	public static String encrypt(String data) {
		String code = getEncryptData(dataInArrayInt(data), keyArrayInt());
		return code;
	}
	
	public static String decrypt(String data) {
		data = getDecryptData(dataInArrayInt(data), keyArrayInt());
		return data;
	}
}
