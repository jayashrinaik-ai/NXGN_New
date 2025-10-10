package pageLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentAttendanceListpage {
	
	
   private	WebDriver driver;
   
   private WebDriverWait wait;
   
   // initialize the constructor
   
   public StudentAttendanceListpage(WebDriver driver)
   {
	   this.driver = driver;
	   
	   PageFactory.initElements(driver, this);
	  
	   this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
   }
	
   
   // Locators
   
   @FindBy(xpath ="//*[@id=\"addRowsBtn\"]")
   
    private WebElement AddAttendanceCTA;
   
   // Action class ..Click on add Attendance CTA
   
   public void click_On_Add_Attendance_CTA()
   {
	   wait.until(ExpectedConditions.visibilityOf(AddAttendanceCTA));
	   
	   AddAttendanceCTA.click();
   }

   // get current  page title to verify ..Method to get page title
   
   public String get_student_Attendance_PageTitle()
   {
	   return driver.getTitle();
   }
   
   
   
   
}
