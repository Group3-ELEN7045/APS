package za.ac.wits.elen7045.group3.aps.services.accounts.statement.generator;

import com.thoughtworks.xstream.XStream;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.notification.ConfirmationNotification;
import za.ac.wits.elen7045.group3.aps.services.notification.FileNotification;
import za.ac.wits.elen7045.group3.aps.services.util.StatementDataMarshaller;

public class HTMLRenderer implements Statement{
   public BillingAccountStatement statement;
 
   public HTMLRenderer(BillingAccountStatement statement){
	   this.statement = statement;
   }

   @Override
   public void saveStatement(String location) {
	   StatementDataMarshaller<BillingAccountStatement> dataMarshaller = new  
       StatementDataMarshaller<BillingAccountStatement>(new XStream()); 
	   String parsedBillingAccountStatement = dataMarshaller.unMarshallToXML("Statement", BillingAccountStatement.class, statement);
	   ConfirmationNotification persistNotification = new FileNotification(parsedBillingAccountStatement, location);
	   persistNotification.sendNotification();
   }
}
