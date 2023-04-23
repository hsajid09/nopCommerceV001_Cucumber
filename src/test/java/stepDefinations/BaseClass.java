package stepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage  searchCust;
	public static Logger logger;
	
	
	public static String randomString() {
		
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		
		return (generatedString1);
		
	}
	

}
