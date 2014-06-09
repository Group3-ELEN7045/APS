<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.security;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptionModuleImpl implements EncryptionModule{

	@Override
	public String encrypt(String encryptString) {
		
		return new String(new BASE64Encoder().encode(encryptString.getBytes()));
	}

	@Override
	public  String decrypt(String decryptString) throws IOException {
		
		return new String(new BASE64Decoder().decodeBuffer(decryptString));
	}

} 
=======
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.security;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptionModuleImpl implements EncryptionModule{

	@Override
	public String encrypt(String encryptString) {
		
		return new String(new BASE64Encoder().encode(encryptString.getBytes()));
	}

	@Override
	public  String decrypt(String decryptString) throws IOException {
		
		return new String(new BASE64Decoder().decodeBuffer(decryptString));
	}

} 
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
