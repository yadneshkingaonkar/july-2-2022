package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messengerpage {
	@FindBy (xpath = "//a[text()='Rooms']")
	WebElement Rooms;
	
	@FindBy (xpath = "//a[text()='Features']")
	WebElement Features;
	
	@FindBy (xpath = "//a[text()='Desktop App']")
	WebElement Desktopapp;
	
	@FindBy (xpath = "//button[text()='Log in']")
	WebElement loginbutton;
	
	@FindBy (xpath ="//a[text()='Privacy & Safety']")
	WebElement Privecysefety;
	
	
	//constructor intilization
	public Messengerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods action on webelement
	
	public void ClickonRoomsTab() {
		Rooms.click();
	}
		public void ClickonFeaturesTab() {
			Features.click();;
		}
		
		public void ClickonDesktopappTab() {
			Desktopapp.click();
			
			
		}
		public void clickonPrivecysefetyTab() {
			Privecysefety.click();
		}
}

