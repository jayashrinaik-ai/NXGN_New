package pageLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_UplaodContentPage {
	

	public WebDriver driver;
	
	public WebDriverWait wait;
	
	// constructor
	
	public Add_UplaodContentPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}
	
	// Locators
	
	@FindBy(xpath="")
	
	private WebElement contentTitleField;
	
	@FindBy(xpath="")

	private WebElement contentTypedropdown;

	@FindBy(xpath="")

	private WebElement contentTypeField;
	
	
	@FindBy(xpath="")
	
	private WebElement selectionStudentoption;
	
	@FindBy(xpath="")

	private WebElement BranchDropdown;
	
	@FindBy(xpath="")

	private WebElement branchvalue;
	
	@FindBy(xpath="")

	private WebElement departmentDropdown;
	
	@FindBy(xpath="")

	private WebElement departmentValue;
	
	@FindBy(xpath="")

	private WebElement programedropdownField;
	
	@FindBy(xpath="")

	private WebElement programevalue;
	
	@FindBy(xpath="")

	private WebElement semesterDropdownField;
	
	@FindBy(xpath="")

	private WebElement semesterValue;
	
	@FindBy(xpath="")

	private WebElement semesterLabelDropdownFieldValue;
	
	@FindBy(xpath="")

	private WebElement semesterLabelValue;
	
	@FindBy(xpath="")

	private WebElement sectionDropdownField;
	
	@FindBy(xpath="")

	private WebElement sectionvalue;
	
	@FindBy(xpath="")

	private WebElement subjectDropdownField;
	
	@FindBy(xpath="")

	private WebElement subjectValue;
	
	@FindBy(xpath="")

	private WebElement DateDropdownField;
	
	@FindBy(xpath="")

	private WebElement dateFieldValue;
	
	@FindBy(xpath="")

	private WebElement DescriptionField;
	
	@FindBy(xpath="")

	private WebElement saveButton;
	
	
	// Action Methods
	
	
}




























