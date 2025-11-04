package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static String takeScreenshot(WebDriver driver, String testname ) {
		
		 // Defensive null check
		
		if(driver==null)
		{
			System.out.println("WebDriver is null. Screenshot cannot be taken.");
			
			return null;
		}
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String screenshotpath = System.getProperty("user.dir")+ "/test-output/screenshots/" + testname + "_" + timestamp+ ".png";
		
		
		
		try {
			
			File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File(screenshotpath));
			
			return screenshotpath;
			
		} catch (Exception e)
		{
			
			e.printStackTrace();
			
			return "Screenshot Failed " + testname + ".png";
		}
		
		
	}

}
