package za.ac.wits.elen7045.group3.aps.domain.accounts.statement.gnerator;

import com.thoughtworks.xstream.XStream;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.notification.ConfirmationNotification;
import za.ac.wits.elen7045.group3.aps.services.notification.FileNotification;
import za.ac.wits.elen7045.group3.aps.services.util.StatementDataMarshaller;

public class HTMLRenderer implements Statement{
   public AbstractBillingAccountStatement statement;
 
   public HTMLRenderer(AbstractBillingAccountStatement statement){
	   this.statement = statement;
   }

   @Override
   public void saveStatement(String location) {
	   StatementDataMarshaller<AbstractBillingAccountStatement> dataMarshaller = new  
       StatementDataMarshaller<AbstractBillingAccountStatement>(new XStream()); 
	   String parsedBillingAccountStatement = dataMarshaller.unMarshallToXML("Statement", AbstractBillingAccountStatement.class, statement);
	   ConfirmationNotification persistNotification = new FileNotification(parsedBillingAccountStatement, location);
	   persistNotification.sendNotification();
   }
}
