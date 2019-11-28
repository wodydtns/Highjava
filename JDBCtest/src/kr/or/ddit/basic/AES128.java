package kr.or.ddit.basic;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import util.CipherUtil;

public class AES128 {

	
	public static void main(String[] args) {
		
		try {
			String message = "대한민국 일본 미국 영국 캐나다";
			System.out.println("원본 문자열 : " + message);
			
			//키 생성
			String base64key = CipherUtil.generateBase64Key(128);
			byte[] key = CipherUtil.generateKey(128);
			
			//키
			System.out.println("Base64 Key : " + base64key);
			System.out.println("Key : " + Arrays.toString(key));
			
			String base64String = CipherUtil.encryptAES128(base64key, message);
			System.out.println("EncryptAES128(base64 encode) : " + base64String);
			
			String encrypt = CipherUtil.encryptAES128(key, message);
			System.out.println("EncryptAES128 : " + encrypt);
			
		    System.out.println("DecryptAES128(base64 decode) : " + CipherUtil.decryptAES128(base64key, base64String));
		    System.out.println("DecryptAES128 : " + CipherUtil.decryptAES128(key, encrypt));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
	
}
