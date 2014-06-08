/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.util;

/**
 * @author SilasMahlangu
 *
 */

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateUtil.
 */
public class DateUtil{
  
  /** The date format. */
  public static String DATE_FORMAT = "dd/MM/yyyy";

  /**
   * Gets the current date.
   *
   * @return the current date
   */
  public static synchronized String getCurrentDate(){
    return new SimpleDateFormat(DATE_FORMAT).format(new Date());
  }

  /**
   * Gets the current date.
   *
   * @param format the format
   * @return the current date
   */
  public static synchronized String getCurrentDate(String format){
    if (format == null) {
      format = DATE_FORMAT;
    }
    SimpleDateFormat f = new SimpleDateFormat(format);
    return f.format(new Date());
  }

  /**
   * Gets the date.
   *
   * @param aDate the a date
   * @param format the format
   * @return the date
   */
  public static synchronized String getDate(Date aDate, String format){
    String myFormat = DATE_FORMAT;
    if (format != null) {
      myFormat = format;
    }
    SimpleDateFormat f = new SimpleDateFormat(myFormat);
    return f.format((aDate == null) ? new Date() : aDate);
  }

  /**
   * Format date.
   *
   * @param format the format
   * @param date the date
   * @return the date
   */
  public static synchronized Date formatDate(String format, String date){
    if ((date == "") || (date == null)) {
      date = getCurrentDate();
    }
    SimpleDateFormat sfd = new SimpleDateFormat(format);
    Date dt = sfd.parse(date, new ParsePosition(0));
    return dt;
  }
}