package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAttendanceListpage {
	
	
   private	WebDriver driver;
   
   // initialize the constructor
   
   public StudentAttendanceListpage(WebDriver driver)
   {
	   this.driver = driver;
	   
	   PageFactory.initElements(driver, this);
	   
   }
	
   
   // Locators
   
   @FindBy(xpath = "//*[@id=\"addRowsBtn\"]")
   
    private WebElement AddAttendanceCTA;
   
   // Action class ..Click on add Attendance CTA
   
   public void click_On_Add_Attendance_CTA()
   {
	   AddAttendanceCTA.click();
   }

   // get current  page title to verify ..Method to get page title
   
   public String get_student_Attendance_PageTitle()
   {
	   return driver.getTitle();
   }
   
   
   
   
}
