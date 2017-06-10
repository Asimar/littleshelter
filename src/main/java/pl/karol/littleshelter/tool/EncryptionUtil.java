package pl.karol.littleshelter.tool;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.log4j.Log4j;

@Log4j
public class EncryptionUtil {

	private static final String key = "Shel3450ter67890";

	private static final Key aesKey = new SecretKeySpec(key.getBytes(), "AES");

	public static String encryptData(String data) {
		Cipher cipher = null;
		byte[] encrypted = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			log.info("Cannot create cipher");
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			log.info("Invalid cipher key");
		}
		try {
			encrypted = cipher.doFinal(data.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			log.info("Cannot encrypt data");
		}
		
		return new String(Base64.getEncoder().encodeToString(encrypted));
	}

	public static String decryptData(String data) {
		Cipher cipher = null;
		byte[] decrypted = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			log.info("Cannot create cipher");
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
		} catch (InvalidKeyException e) {
			log.info("Invalid cipher key");
		}
		try {
			decrypted = cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			log.info("Cannot decrypt data");
		}	
		
		return new String(decrypted);
	}

}
