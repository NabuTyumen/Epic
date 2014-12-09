package service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassWord {
	private static final MessageDigest digest = getDigest();
	
	public byte[] getHash(String pw){
		 try {
			return digest.digest(pw.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static MessageDigest getDigest() {
		try {
			return  MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		};
		return null;
	}
	
}
