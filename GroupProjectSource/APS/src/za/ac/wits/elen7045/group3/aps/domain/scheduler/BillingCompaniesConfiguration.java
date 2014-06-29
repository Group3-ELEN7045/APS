package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.quartz.CronTrigger;

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
	private static BillingCompaniesConfiguration billingCompaniesConfiguration = null;
	
	private static BillingCompaniesConfigurationHelper companiesConfigurationHelper;
	
	private List<BillingCompany> billingCompanies = new ArrayList<BillingCompany>();
	
	/**
	 * 
	 */
	private BillingCompaniesConfiguration() {
		class Company {
			String companyName = "";
			String url = "";
			List<String> billingCycle = new ArrayList<String>();
			List<String> maintenanceWindows = new ArrayList<String>();
			List<String> peakPriods = new ArrayList<String>();
		}
		
		class Companies {
			List<Company> companies = new ArrayList<Company>();
		}
	
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("billing-companies", Companies.class);
		xstream.alias("billing-company", Company.class);
		xstream.alias("maintenance-windows", List.class);
		xstream.alias("cron-expression", String.class);
		xstream.alias("peak-periods", List.class);
		xstream.alias("billing-cycle", List.class);
		xstream.aliasField("name", Company.class, "companyName");
		xstream.aliasField("url", Company.class, "url");
		xstream.aliasField("billing-cycle", Company.class, "billingCycle");
		xstream.aliasField("maintenance-windows", Company.class, "maintenanceWindows");
		xstream.aliasField("peak-periods", Company.class, "peakPriods");
		xstream.addImplicitCollection(Companies.class, "companies");
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Billing-Companies-Config.xml");                     
		Companies companies = (Companies) xstream.fromXML(inputStream);
		List<Company> companies2 = companies.companies;
		
		for (Company company : companies2) {
			BillingCompany billingCompany = new BillingCompany(company.companyName);
			billingCompany.setURL(company.url);
			CronTrigger cronTrigger = new CronTrigger();
			
		
				/*System.out.println(company.billingCycle.get(0));
				cronTrigger.setCronExpression(company.billingCycle.get(0));
				
				Date startDate = cronTrigger.getNextFireTime();
				Date endDate = cronTrigger.getNextFireTime();
				System.out.println(startDate);
				System.out.println(endDate);*/
				BillingCycle billingCycle = new BillingCycle();
				Calendar calendar = Calendar.getInstance();
				billingCycle.setStartDate(calendar.getTime());
				calendar.add(Calendar.SECOND, 5);
				billingCycle.setEndDate(calendar.getTime());
				System.out.println(billingCompany);
			    billingCompany.setMaintenancewindow(new CronExpressionWrapper());
			    billingCompany.setPeakperiod(new CronExpressionWrapper());
			    this.billingCompanies.add(billingCompany);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static synchronized BillingCompaniesConfiguration getInstance() {
		if (billingCompaniesConfiguration == null) {
			billingCompaniesConfiguration = new BillingCompaniesConfiguration();
		}
		
		return billingCompaniesConfiguration;
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<BillingCompany> loadBillingCompanies() {
		return this.billingCompanies;
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                date = dateFormat.parse(reader.getValue());
            } catch (ParseException ex) {
                throw new ConversionException(ex.getMessage(), ex);
            }
            
            return date;
	    }
	}
}
