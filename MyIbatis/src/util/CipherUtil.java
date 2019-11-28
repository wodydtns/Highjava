package util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class CipherUtil {
	
	//keySize에 따른 AES 암호화 키 생성 (base64 인코딩 처리)
	public static String generateBase64Key(int keySize) throws Exception {		
		
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(keySize);
		Key secretKey = generator.generateKey();
		
		return DatatypeConverter.printBase64Binary(secretKey.getEncoded());
	}
	
	//keySize에 따른 AES 암호화 키 생성
	public static byte[] generateKey(int keySize) throws Exception {		
		
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(keySize);
		Key secretKey = generator.generateKey();
		
		return secretKey.getEncoded();
	}
	
	//문자열을 key를 통해 암호화 하고 base64 로 인코딩
	public static String encryptAES128(byte[] key, String message) throws Exception {
		
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	    byte[] encrypted = cipher.doFinal(message.getBytes()); //encrypt
	    
	    String encodeString = DatatypeConverter.printBase64Binary(encrypted); //Converts an array of bytes into a string.

		return encodeString;
	}
	
	//base64로 인코딩된 key 를 통해 문자열 base64 인코딩 
	public static String encryptAES128(String base64Key, String message) throws Exception {
		return encryptAES128(base64DecodeKey(base64Key), message);
	}

	//key 를 통해 문자열 base64 디코딩
	public static String decryptAES128(byte[] keys, String encrypted)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		
		SecretKeySpec keySpec = new SecretKeySpec(keys, "AES");

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);

		byte[] decodeBytes = DatatypeConverter.parseBase64Binary(encrypted); //Converts the string argument into an array of bytes.
		byte[] decryptBytes = cipher.doFinal(decodeBytes); //decrypt
		
		return new String(decryptBytes);	
	}

	//base64로 인코딩된 key 를 통해 문자열 base64 디코딩
	public static String decryptAES128(String base64Key, String encrypted)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
				
		return decryptAES128(base64DecodeKey(base64Key), encrypted);	
	}
	
	//base64로 인코딩된 key를 byte 배열로 디코딩
	public static byte[] base64DecodeKey(String base64Key) {
		return DatatypeConverter.parseBase64Binary(base64Key);		
	}
	
	//byte배열의 키를 base64로 인코딩
	public static String base64EncodeKey(byte[] key) {
		return DatatypeConverter.printBase64Binary(key);
	}
	
}
