package co.edu.eam.disenosoftware.mitienda.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * EncrypterUtil class
 */
public class EncrypterUtil {

  /**
   * Method to password MD5
   * @param input parameter to input
   * @return hash_text
   */
  public static String getMD5(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger number = new BigInteger(1, messageDigest);
      final int value = 16;
      String hashtext = number.toString(value);
      final int value2 = 32;
      while (hashtext.length() < value2) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
