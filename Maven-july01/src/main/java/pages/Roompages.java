package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roompages {

	
	@FindBy (xpath="//a[text()=' Return to messenger.com ']")
	 private WebElement returnButton;
	
	@FindBy (xpath=" //a[text()=' Visit our help center '] ")
	 private WebElement contacTohelpcenter;
	
	
	public Roompages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void returntoMessenger() {
		returnButton.click();
	}
	
	public void gobackHelpcenter() {
		contacTohelpcenter.click();
	}
}

//POM
//Webelemnt related