package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	public static void waitForPreloaderToDisappear(WebDriver driver)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.preloader")));
		}
		catch(Exception e){
			
			System.out.println("Preloader not found or already hidden.");
			
		}
	}
}
