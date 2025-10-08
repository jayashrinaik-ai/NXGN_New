package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardpage {

	//Constructor
	
	public AdminDashboardpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Locators
	
	@FindBy(xpath = "//*[@id=\"sidebar_menu\"]/li[4]/a")
	
	private WebElement StudentInfoModule ;
	
	
	// Action Method
	
	public void click_On_Student_Info_Module()
	{
		StudentInfoModule.click();
	}
}
