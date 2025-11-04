package pageLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Study_material_Upload_content_Listpage {
	
	public WebDriver driver;
	
	public WebDriverWait wait;
	
	// constructor
	
	public Study_material_Upload_content_Listpage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}

	
	// Locators
	
	@FindBy (xpath= "//*[@id=\"addRowsBtn\"]")
	
	private WebElement uploadContentCTA;
	
	
	
	public void click_On_upload_Content_CTA()
	{
		uploadContentCTA.click();
	}
}
