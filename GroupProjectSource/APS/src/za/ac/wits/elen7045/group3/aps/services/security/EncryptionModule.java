/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.security;

import java.io.IOException;

/**
 * @author SilasMahlangu
 *
 */
public interface EncryptionModule {
    public String encrypt(String encryptString);
    public String decrypt(String decryptString)throws IOException;
}
