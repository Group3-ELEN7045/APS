/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

/**
 * @author SilasMahlangu
 *
 */
public class FileNotification extends ConfirmationNotification{
	
	private String notificationData;
	private String filePath;
	private StringWriter stringWriter = new StringWriter();
	private InputStream inputStream; 
	private String responseString;
	
	public FileNotification(String notificationData,String filePath){
		this.notificationData = notificationData;
		this.filePath = filePath;
	}

	@Override
	public boolean sendNotification() {
		return notifyUser(notificationData);
	}
   
	@Override
	public String getNotification() {
		try{
		  inputStream = new FileInputStream(new File(filePath));//);// this.getClass().getResourceAsStream(filePath);
		  IOUtils.copy(inputStream, stringWriter, "UTF-8");
		  responseString = stringWriter.toString();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}  
		return responseString;
	}

	//logging, save notifications to file
	private boolean notifyUser(String notificationData){
		FileOutputStream fout = null;
		boolean response = false;
		try {
			fout = new FileOutputStream(new File(filePath));
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