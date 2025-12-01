package pageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogHelper;
import utils.WaitUtil;

public class StudentAttendanceListpage {
	
	
   private	WebDriver driver;
   
   private WebDriverWait wait;
   
   // initialize the constructor
   
   public StudentAttendanceListpage(WebDriver driver)
   {
	   this.driver = driver;
	   
	   PageFactory.initElements(driver, this);
	  
	   this.wait = new WebDriverWait(driver,Duration.ofSeconds(60));
   }
	
   
   // Locators
   
   @FindBy(xpath="//*[@id=\"addRowsBtn\"]")
   
    private WebElement AddAttendanceCTA;
   
   // Action class ..Click on add Attendance CTA
   
   public void click_On_Add_Attendance_CTA()
   
   {
//																		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.preloader")));
//																		   
//																		   WaitUtil.waitForPreloaderToDisappear(driver);
//																		   
//																		  wait.until(ExpectedConditions.visibilityOf(AddAttendanceCTA));
//																		   
//																		   try {
//																			   
//																			   AddAttendanceCTA.click();
//																		   } 
//																		   catch (Exception e)
//																		   
//																		   {
//																			   ((JavascriptExecutor) driver).executeScript("arguments[0].click()", AddAttendanceCTA);
//																		   }
//																		   
//																		   AddAttendanceCTA.click();
	   
	  
	   LogHelper.info("clicking on Add attendace CTA");
	   
	   wait.until(ExpectedConditions.visibilityOf(AddAttendanceCTA));
	   
	   AddAttendanceCTA.click();
	   
	   
   }

   // get current  page title to verify ..Method to get page title
   
   public String get_student_Attendance_PageTitle()
   {
	   return driver.getTitle();
   }
   
   
   
   
}
