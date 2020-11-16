package co.edu.eam.disenosoftware.mitienda.utils;

/**
 * Method to check if the phone is a number
 */
public class PhoneNumberUtil {

  /**
   * Is numeric
   * @param phone phone number
   * @return boolean
   */
  public static boolean isNumeric(String phone) {
    try {
      Long.parseLong(phone);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}
