package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement  txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(css="button[type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="logout")
	WebElement lnkLogout;
	
	public void setUserName(String uname) throws InterruptedException {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) throws InterruptedException {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() throws InterruptedException {
		
		lnkLogout.click();
	}
	
	
}
