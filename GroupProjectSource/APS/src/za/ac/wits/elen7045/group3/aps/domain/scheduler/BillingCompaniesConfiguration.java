package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 
 * @author Ronald Menya
 *
 */
public final class BillingCompaniesConfiguration implements Cloneable {
	
	/**
	 * 
	 */
	private static BillingCompaniesConfiguration billingCompaniesConfiguration = new BillingCompaniesConfiguration();
	
	private BillingCompaniesConfigurationHelper companiesConfigurationHelper;
	
	/*
	 * 
	 */
	private static XStream xstream = initializeXStream();
	
	/**
	 * 
	 * @return
	 */
	private static XStream initializeXStream () {
		
		//Billing Company aliases
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("billing-companies", BillingCompaniesConfigurationHelper.class);
		xstream.alias("billing-company", BillingCompany.class);
		xstream.aliasField("name", BillingCompany.class, "companyName");
		xstream.aliasField("url", BillingCompany.class, "url");
		xstream.addImplicitCollection(BillingCompany.class, "maintenanceWindows");
		xstream.addImplicitCollection(BillingCompany.class, "peakPeriods");
		xstream.addImplicitCollection(BillingCompaniesConfigurationHelper.class, "companies");
		xstream.alias("billing-cycle", BillingCycle.class);
		xstream.alias("start-date", Date.class);
		xstream.alias("end-date", Date.class);
		xstream.aliasField("start-date", BillingCycle.class, "startDate");
		xstream.aliasField("end-date", BillingCycle.class, "endDate");
		xstream.aliasField("seconds", CronExpressionWrapper.class, "seconds");
		xstream.aliasField("minutes", CronExpressionWrapper.class, "minutes");
		xstream.aliasField("hours", CronExpressionWrapper.class, "hours");
		xstream.aliasField("day-of-month", CronExpressionWrapper.class, "dayOfMonth");
		xstream.aliasField("month", CronExpressionWrapper.class, "month");
		xstream.aliasField("day-of-week", CronExpressionWrapper.class, "dayOfWeek");
		xstream.aliasField("year", CronExpressionWrapper.class, "year");
		xstream.alias("maintenance-window", CronExpressionWrapper.class);
		xstream.alias("peak-period", CronExpressionWrapper.class);
		xstream.registerConverter(new DateConverter());
		return xstream;
	}
	
	/**
	 * 
	 */
	private BillingCompaniesConfiguration() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Billing-Companies-Config.xml");                     
		companiesConfigurationHelper = (BillingCompaniesConfigurationHelper) xstream.fromXML(inputStream);
	}
	
	/**
	 * 
	 * @return
	 */
	public static BillingCompaniesConfiguration getInstance() {
		return billingCompaniesConfiguration;
	}
	
	/**
	 * 
	 * @return
	 */
	public BillingCompaniesConfigurationHelper loadBillingCompanies() {
		return this.companiesConfigurationHelper;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * 
	 * @author Ronald Menya
	 *
	 */
	private static class DateConverter implements Converter {
        
		/**
		 * 
		 */
	    public boolean canConvert(Class type) {
	        return type.equals(Date.class);
	    }
        
	    /**
	     * 
	     */
	    public void marshal(Object value, HierarchicalStreamWriter writer,
	            MarshallingContext context) {
            Date date = (Date) value;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            writer.setValue(dateFormat.format(date));
	    }

	    /**
	     * 
	     */
	    public Object unmarshal(HierarchicalStreamReader reader,
                UnmarshallingContext context) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            
            try {
                date = dateFormat.parse(reader.getValue());
            } catch (ParseException ex) {
                throw new ConversionException(ex.getMessage(), ex);
            }
            
            return date;
	    }
	}
}
