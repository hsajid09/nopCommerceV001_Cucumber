package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnkCutomer_menu= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomer_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnew=By.xpath("//a[normalize-space()='Add new']");
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtpassword=By.xpath("//input[@id='Password']");
	
	By txtcustomerRolls=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrator=By.xpath("//li[contains(.,'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(.,'Registered')]");
	By lsitemGuests=By.xpath("//li[contains(.,'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(.,'Vendors')]");
	
	By drpmgrOfVendors=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
		
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	public String getPageTitle() {
		
		return ldriver.getTitle();
	}
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCutomer_menu).click();
	}
	
	public void clickOnCutomersMenuItem() {
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtpassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		
		if(!role.equals("Vendors")) {
			ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"));
		}
		ldriver.findElement(txtcustomerRolls).click();
		WebElement listitem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) {
			listitem=ldriver.findElement(lstitemAdministrator);
		}else if(role.equals("Guests")) {
			listitem=ldriver.findElement(lsitemGuests);
		}else if(role.equals("Registered")) {
			listitem=ldriver.findElement(lstitemRegistered);
		}else if (role.equals("Vendors")) {
			listitem=ldriver.findElement(lstitemVendors);
		}else {
			listitem=ldriver.findElement(lsitemGuests);
		}
		//listitem.click();
		
		JavascriptExecutor js= (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listitem);
	}
	public void setManagerOfVendors(String value) {
		Select drp=new Select(ldriver.findElement(drpmgrOfVendors));
		drp.selectByVisibleText(value);
	}
	public void setGender(String gender) {
		if(gender.equals("Male")){
			ldriver.findElement(rdFeMaleGender).click();
			
		}else if(gender.equals("Female")) {
			ldriver.findElement(rdMaleGender).click();
				
			}else {
				ldriver.findElement(rdMaleGender);
			}
		}
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
		
}
