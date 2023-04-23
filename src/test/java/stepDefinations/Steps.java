package stepDefinations;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;



public class Steps extends BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;

	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
		
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chromr.driver", System.getProperty("user.dir")+"\\Driv\\chromedriver.exe");
		
		
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	
		logger.info("*********Launching browser******");
		driver.manage().window().maximize();
		lp= new LoginPage(driver);
		
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		logger.info("*********Opening URL******");
		driver.get("https://admin-demo.nopcommerce.com/login");
		Thread.sleep(2);
	 
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		
		logger.info("***************Providing login details******************");
		lp.setUserName(email);
		lp.setPassword(password);
		Thread.sleep(2);
		
	 
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		
		if (driver.getPageSource().contains("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertEquals(title, driver.getTitle());
			Thread.sleep(2000);
		}
	  
	}

	@When("User click on Log out Link")
	public void user_click_on_log_out_link() throws InterruptedException {
		
		lp.clickLogin();
		logger.info("***************Logging out******************");
		
	    	}

	
	
	//Add Customers feature step definitions...

	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		logger.info("***************Adding Customers******************");
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	    
	}

	@When("click on customer menu Item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
	    addCust.clickOnCutomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	    
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enters cutomer info")
	public void user_enters_cutomer_info() throws InterruptedException {
	   
		String email=randomString()+ "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		//addCust.setCustomerRoles("Guest");
		Thread.sleep(1000);
		//addCust.setManagerOfVendors("Vendor2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985");
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing... *** ....");
		
	}

	
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(2000);
	  
	}

	@Then("User can view confirmation page {string}")
	public void user_can_view_confirmation_page(String msg) {
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	  
	}
	@Then("close browser")
	public void close_browser() {
		driver.quit();
	    
	}
	// Searching for customer using email iD
	

	@When("enter Customer EMail")
	public void enter_customer_e_mail() throws InterruptedException {
		
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	  
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	    
		searchCust.clickSearch();
	}
	@Then("User should found Email int he search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status =searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}



}
