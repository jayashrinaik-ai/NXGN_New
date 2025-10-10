package utils;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ActionHelper {
	
	private WebDriver driver;
	
	 // Constructor to initialize WebDriver
	
	public ActionHelper(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	

    // ✅ Method 1: Open link in new tab using Ctrl + Click
	
	public void open_Link_In_New_Tab(WebElement element)
	{
		Actions action = new Actions(driver);
		
		action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
		
	//	switchToLatestTab();
				
	}
	

    // ✅ Method 4: Switch to the latest opened tab/window

	public void switchToLatestTab(WebElement element)
	{
		
		Set<String> handles = driver.getWindowHandles();
		
		for( String handle : handles)
		{
			driver.switchTo().window(handle);
		}
	}
}
