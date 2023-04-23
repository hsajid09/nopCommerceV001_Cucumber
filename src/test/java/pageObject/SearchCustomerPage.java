package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHepler;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHepler waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHepler(ldriver);		
	}
	
	@FindBy(how=How.ID , using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID , using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID , using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID , using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how=How.ID , using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how=How.ID , using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how=How.XPATH , using="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	@FindBy(how=How.XPATH , using="//li[contains(text), 'Administrator']")
	@CacheLookup
	WebElement lstitemAdminstrators;
	
	@FindBy(how=How.XPATH , using="//li[contains(text), 'Registered']")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how=How.XPATH , using="//li[contains(text), 'Guests']")
	@CacheLookup
	WebElement lstitemGuests;
	
	@FindBy(how=How.XPATH , using="//li[contains(text), 'Vendors']")
	@CacheLookup
	WebElement lstitemVendors;

	@FindBy(how=How.ID , using="search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH , using="//table[@role=, 'grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how=How.XPATH , using="//table[@id= 'customer-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how=How.XPATH , using="//table[@id= 'customer-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(how=How.XPATH , using="//table[@id= 'customer-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumn;
	
	public void setEmail(String email) throws InterruptedException {
		Thread.sleep(5000);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void SetFirstName(String fname) throws InterruptedException {
		Thread.sleep(5000);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) throws InterruptedException {
		Thread.sleep(5000);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	public void clickSearch() throws InterruptedException {
		btnSearch.click();
		Thread.sleep(5000);
		
	}
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	public int getNoOfColumn() {
		return(tableColumn.size());
	}
	public boolean searchCustomerByEmail(String email) {
		boolean flag= false;
		
		for (int i=1; i<=getNoOfRows(); i++) {
			String emailid=table.findElement(By.xpath("//table[@id= 'customer-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.print(emailid);
			if(emailid.equals(email)) {
				flag=true;
			}
		}
		
		return false;
		
		
	}
	
}
