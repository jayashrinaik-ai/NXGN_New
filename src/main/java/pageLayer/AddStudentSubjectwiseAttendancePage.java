package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddStudentSubjectwiseAttendancePage {
	
	public WebDriver driver;
	
	// Constructor
	
	public AddStudentSubjectwiseAttendancePage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	// store all xpath in webelements
	
	// Xpath of SubjectCategoryType 
	
	@FindBy(xpath = "//*[@id=\"subject_category_div\"]/div[1]")
	
	private WebElement SubjectCategoryTypedrpdown;
	
	@FindBy (xpath = "//*[@id=\"subject_category_div\"]/div[1]/ul/li[2]")

	private WebElement subjectCategoryTypeValue;
	
	// Xpath of branch and branch value
	
	@FindBy(xpath = "//*[@id=\"select_faculty_div\"]/div[1]")
	
	private WebElement branch;
	
	// select department
	
	@FindBy (xpath = "//*[@id=\"select_department_div\"]/div[1]")
	
	private WebElement departmentDropdown;
	
	
	// xpath of subject
	
	@FindBy (xpath =" ")
	
	private WebElement subject;
	
	@FindBy (xpath = "")
	
	private WebElement attendanceDate;
	
	
	
	
	public void select_subject_category_type()
	{
		SubjectCategoryTypedrpdown.click();
		subjectCategoryTypeValue.click();
	}
}
