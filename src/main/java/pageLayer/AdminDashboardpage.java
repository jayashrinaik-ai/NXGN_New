package pageLayer;

import java.time.Duration;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ActionHelper;

public class AdminDashboardpage {

	public WebDriver driver;
	
	private WebDriverWait wait;
	
	private ActionHelper actionhelper;
	

		
	//Constructor
	
	public AdminDashboardpage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		// Initialized helper
		actionhelper = new ActionHelper(driver);
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}
	
	
	//Locators
	
		@FindBy(xpath = "//*[@id=\"sidebar_menu\"]/li[4]/a")
		
		private WebElement StudentInfoModule ;
		
		@FindBy (xpath = "//*[@id=\"sidebar_menu\"]/li[4]/ul/li[7]/a")
		
		private WebElement SubjectWiseAttendanceSubModuel ;
		
		
		@FindBy(xpath= "//*[@id=\"sidebar_menu\"]/li[5]/a")
		
		
		private WebElement StudyMaterialfield;
		
		@FindBy(xpath = "//*[@id=\"sidebar_menu\"]/li[5]/ul/li[1]/a")
		
		private WebElement uploadContentmodule;
	
	
	
	// Action Method
	
	public void click_On_Student_Info_Module()
	
	{
		
		wait.until(ExpectedConditions.visibilityOf(StudentInfoModule));
		StudentInfoModule.click();
	}
	
    // Action method with wait
	
	public void click_On_Subjectwise_Attendance_Submodule_In_New_Tab()
	{
		
		
      
		//wait.until(ExpectedConditions.visibilityOf(StudentInfoModule));
		//SubjectWiseAttendanceSubModuel.click();
		
		// click is not working we provide some wait on that element
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SubjectWiseAttendanceSubModuel);
		//wait.until(ExpectedConditions.elementToBeClickable(SubjectWiseAttendanceSubModuel));
	
		// called here action class to open in new window for this link
		
		
		wait.until(ExpectedConditions.visibilityOf(SubjectWiseAttendanceSubModuel));
		
		actionhelper.open_Link_In_New_Tab(SubjectWiseAttendanceSubModuel);
		
		actionhelper.switchToLatestTab(SubjectWiseAttendanceSubModuel);
	
	}
	
	public void click_On_Study_Material()
	{
		
	//	wait.until(ExpectedConditions.visibilityOf(StudyMaterialfield));
		
		StudyMaterialfield.click();
		
	}
	
	public void click_On_UploadContent_module()
	{
		wait.until(ExpectedConditions.visibilityOf(uploadContentmodule));
		

		actionhelper.open_Link_In_New_Tab(uploadContentmodule);
		
		actionhelper.switchToLatestTab(uploadContentmodule);
		
	}
}











