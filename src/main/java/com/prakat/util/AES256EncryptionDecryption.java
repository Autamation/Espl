package com.prakat.util;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import sun.misc.*;

public class AES256EncryptionDecryption {

	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	public static String encrypt(String Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedValue = c.doFinal(Data.getBytes());
		return new BASE64Encoder().encode(encryptedValue);
	}

	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decryptedValue = c.doFinal(decordedValue);
		System.out.println(new String(decryptedValue));
		return new String(decryptedValue);
	}

	private static Key generateKey() throws Exception {
		return new SecretKeySpec(keyValue, ALGO);
	}
	
	public static void main(String args[]) throws Exception{
		decrypt("ANkfLWv8U2keMkGXCuontw==");
	}

}