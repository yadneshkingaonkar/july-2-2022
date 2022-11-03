package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
//variable - WebElement
	@FindBy (xpath = "//input[@id='email']")
	WebElement userName;
	
	@FindBy (xpath = "//input[@id='pass']")
	WebElement Password;
	
	@FindBy (xpath = "//button[text()='Log in']")
	WebElement loginbutton;
	
	@FindBy (xpath = "//a[@title='Take a look at Messenger.']")
	WebElement MessengerLink;
	
	//constructor intilization
	public Loginpage(WebDriver driver12) { //driver123 = driver= new chromedriver
		PageFactory.initElements(driver12, this);
	}
	
	//Methods action on webelement
	public void sendUsername(String name) {
		userName.sendKeys(name);
	}
	
	public void sendpassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickonloginbtn() {
		loginbutton.click();
	}
	public void openMessengrpage() {
		MessengerLink.click();
	}

	
	
	
	
}
