
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */
public class FileNotification extends ConfirmationNotification{
	
	private String notificationData;
	
	public FileNotification(String notificationData){
		this.notificationData = notificationData;
	}

	@Override
	public boolean sendNotification() {
		return notifyUser(notificationData);
	}
   
	//logging
	private boolean notifyUser(String notificationData){
		FileOutputStream fout = null;
		boolean response = false;
		try {
			fout = new FileOutputStream(new File(ApplicationContants.FILE_NAME_NOTIFICATION));
			fout.write(notificationData.getBytes());
			response = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			response = false;
		} catch (IOException e) {
			e.printStackTrace();
			response = false;
		}finally{
			if(fout != null){
			   try {
				  fout.flush();
				  fout.close();
			   } catch (IOException e) {
				  e.printStackTrace();
			   }
			}   
		 }
	    return response;	
	}
}
