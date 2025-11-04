package utils;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {
	
	// Sroll to bottom inside a specific container
	
	public static void scroll_To_Bottom_In_Container( WebDriver driver, WebElement container)
	{
	
		((JavascriptExecutor) driver ).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", container );
	}
	
	
	  // Scroll a specific element into view (optional extra helper)
	
	public static void scroll_Element_Into_View(WebDriver driver, WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
		
		
	}

}
