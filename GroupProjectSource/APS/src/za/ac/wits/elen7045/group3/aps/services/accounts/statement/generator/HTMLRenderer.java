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
	   System.out.println("Saving generated statement");
	   String statementData = statementMarshaller();
	   sendNotification(statementData,location);
   }
   
   private String statementMarshaller(){
	   String xmlprolog = "<?xml version=\"1.0\"?>\n";
	   String xslprolog = "<?xml-stylesheet type=\"text/xsl\" href=\"municipality.xsl\" ?>\n";
	   StatementDataMarshaller<BillingAccountStatement> dataMarshaller = new  
	   StatementDataMarshaller<BillingAccountStatement>(new XStream()); 
	   String parsedBillingAccountStatement = dataMarshaller.unMarshallToXML("MunicipalStatement", BillingAccountStatement.class, statement);
	   String statementData = xmlprolog + xslprolog + parsedBillingAccountStatement;
		
	   return statementData;
   }
   
   public void sendNotification(String statementData, String location){
	   ConfirmationNotification persistNotification = new FileNotification(statementData, location);
	   persistNotification.sendNotification();
   }
}
