package co.edu.eam.disenosoftware.mitienda.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
      int value = 16;
      String hashtext = number.toString(value);
      int value2=32;
      while (hashtext.length() < value2) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      System.out.println("entre AQUI");
      throw new RuntimeException(e);
    }
  }
}