package pageLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddStudentSubjectwiseAttendancePage {

	public WebDriver driver;

	WebDriverWait wait;

	// Constructor

	public AddStudentSubjectwiseAttendancePage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver, Duration.ofSeconds(30)) ;
	}

	// Locators ( store all xpath in webelements) 

	// Xpath of SubjectCategoryType 

	@FindBy(xpath = "//*[@id=\"subject_category_div\"]/div[1]")

	private WebElement SubjectCategoryTypedrpdown;

	@FindBy (xpath ="//*[@id=\"subject_category_div\"]/div[1]/ul/li")

	private List <WebElement> subjectCategoryTypeValues;




	// Xpath of branch and branch value

	@FindBy(xpath = "//*[@id=\"select_faculty_div\"]/div[1]")

	private WebElement branch;

	@FindBy(xpath ="//*[@id=\"select_faculty_div\"]/div[1]/ul/li")

	private List <WebElement> branchValues;



	// select department and Department value

	@FindBy (xpath ="//*[@id=\"select_department_div\"]/div[1]")

	private WebElement departmentDropdown;

	@FindBy (xpath ="//*[@id=\"select_department_div\"]/div[1]/ul/li")

	private List <WebElement> departmentvalues;


	// select program and program value

	@FindBy (xpath="//*[@id=\"select_program_div\"]/div[1]")

	private WebElement programDropdown;

	@FindBy(xpath ="//*[@id=\"select_program_div\"]/div[1]/ul/li")
	
	private List <WebElement> programValues;

	// select semester and semester value

	@FindBy (xpath = "//*[@id=\"select_semester_div\"]/div[1]")

	private WebElement semesterDropdown;

	@FindBy (xpath="//*[@id=\"select_semester_div\"]/div[1]/ul/li")

	private List <WebElement> semestervalues;

	// select semester label and semester label value.

	@FindBy (xpath="//*[@id=\"select_semester_label_div\"]/div[1]")

	private WebElement semesterLabelDropdown;

	@FindBy (xpath="//*[@id=\"select_semester_label_div\"]/div[1]/ul/li")

	private List <WebElement> semesterLabelValues;

	// select section and section value

	@FindBy (xpath="//*[@id=\"select_section_div\"]/div[1]")

	private WebElement sectionDropdown;

	@FindBy (xpath ="//*[@id=\"select_section_div\"]/div[1]/ul/li")

	private List <WebElement> sectionValues;

	// select subject and subject value 

	@FindBy (xpath="//*[@id=\"select_subject_div\"]/div[1]")

	private WebElement subjectdropdown;

	@FindBy (xpath ="//*[@id=\"select_subject_div\"]/div[1]/ul/li")

	private List <WebElement> subjectValues;

	// select attendance date and value


	@FindBy (xpath = "//*[@id=\"startDate\"]")

	private WebElement attendanceDatefield;

	@FindBy (xpath="/html/body/div[5]/div[1]/table/tbody/tr[5]/td")

	private List <WebElement> attendancevalues;


	// select lecture slots and slots value

	@FindBy (xpath= "//*[@id=\"select_lecture_slot_div_multi\"]/div[1]")

	private WebElement lectureslotDropdown;

	@FindBy (xpath="//*[@id=\"select_lecture_slot_div_multi\"]/div[1]/ul/li")

	private List <WebElement> lectureslotValues;


	// select unit and units value

	@FindBy (xpath = "//*[@id=\"select_unit_plan_div_multi\"]/div[1]")

	private WebElement unitDropdown;

	@FindBy (xpath = "//*[@id=\"select_unit_plan_div_multi\"]/div[1]/ul/li")

	private List <WebElement> unitValues;

	// select topic and topic value

	@FindBy (xpath = "//*[@id=\"ms-list-1\"]/button")

	private WebElement topicDropdown;

	@FindBy(xpath = "//*[@id=\"ms-list-1\"]/div/ul/li")

	private List <WebElement> topicValues; 


	// select Status of Topic/ Topic overview 

	@FindBy (xpath= "//*[@id=\"topic_status_fields_wrapper\"]/div/div[2]/div")

	private WebElement TopicOverviewfield;

	@FindBy (xpath ="//*[@id=\"topic_status_fields_wrapper\"]/div/div[2]/div/ul")

	private List <WebElement> topicOverviewStatus;




	public void select_subject_category_type(String subjectcategoryValue)
	{

		wait.until(ExpectedConditions.visibilityOf(SubjectCategoryTypedrpdown));
		SubjectCategoryTypedrpdown.click();


		wait.until(ExpectedConditions.visibilityOfAllElements(subjectCategoryTypeValues));

		// 3. Loop through options and click matching text

		boolean found = false;

		for(WebElement subjectCategoryTypeValue :subjectCategoryTypeValues)
		{
			if(subjectCategoryTypeValue.getText().equalsIgnoreCase(subjectcategoryValue))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectCategoryTypeValue );

				found =true;

				break;


			}
		}

		// Step 4: Throw exception if not found

		if(!found)
		{
			throw new RuntimeException(" Subject Category not found: " + subjectcategoryValue );
		}
	}

	//	subjectCategoryTypeValues.click();


	public void select_branch(String branchesvalue)

	{

		wait.until(ExpectedConditions.visibilityOf(branch));
		branch.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(branchValues));
		
		// 3. Loop through options and click matching text
		
		boolean found = false;
		
		for(WebElement branchvalue : branchValues )
		{
			if(branchvalue.getText().trim().equalsIgnoreCase(branchesvalue.trim()))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",branchvalue );
				
				found = true;
				
				break;
			}
		}
		
		if(!found)
		{
			throw new RuntimeException(" Branch value is not found: " + branchesvalue);
		}
		
		
	}

	public void select_department(String departments)
	{
		
		int maxRetries = 3;
		
		boolean found = false;

		for(int attempt = 1; attempt <= maxRetries; attempt++) {
			
			try {

		wait.until(ExpectedConditions.visibilityOf(departmentDropdown));
		departmentDropdown.click();
		
		
	 List <WebElement> departmentOptions =	wait.until(ExpectedConditions.visibilityOfAllElements(departmentvalues));

		
		// 3. Loop through options and click matching text
		
		for(WebElement departmentoption : departmentOptions)
		{
			if(departmentoption.getText().trim().equalsIgnoreCase(departments.trim()))
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", departmentoption );
				
				found = true;
				
				break;
			}
		}
		
		if(found)
			break;
		
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println("⚠️ StaleElementReferenceException caught! Retrying... (Attempt " + attempt +")");
			}
			
			try {
				Thread.sleep(3000);
			}
			
			catch(InterruptedException ignored){
				
			}
		
		if(!found)
		{
			throw new RuntimeException(" Department Value is not found " + departments );
		}
	}
	}

	public void select_programe(String programes)
	{

		wait.until(ExpectedConditions.visibilityOf(programDropdown));
		programDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\\\"select_program_div\\\"]/div[1]/ul/li")));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(programValues));

		boolean found = false;
		
		// 3. Loop through options and click matching text
		
		for(WebElement progamvalue : programValues)
		{
			
			System.out.println("Program option: " + progamvalue.getText());
			
			if(progamvalue.getText().trim().equalsIgnoreCase(programes.trim()))
				
			{
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", progamvalue);

		        
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", progamvalue);
				
				found = true;
				
				break;
			}
		}
		
		if(!found)
		{
			throw new RuntimeException(" Program value is not found: " + programes );
		}
		
		
	}

	public void select_semester(String semesters)
	{
		wait.until(ExpectedConditions.visibilityOf(semesterDropdown));
		semesterDropdown.click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(semestervalues));
		
		boolean found = false;
		
		// 3. Loop through options and click matching text
		
		for(WebElement semestervalue : semestervalues)
		{
			if(semestervalue.getText().trim().equalsIgnoreCase(semesters.trim()))
			{
				((JavascriptExecutor) driver ).executeScript("arguments[0].click();", semestervalue);
				
				found = true;
				
				break;
				
			}
		}
		
		if(!found)
		{
			throw new RuntimeException(" Semester value is not found: " + semesters );
		}

		
		
	}

	public void select_semester_label(String semesterLabels)
	{
		wait.until(ExpectedConditions.visibilityOf(semesterLabelDropdown));
		semesterLabelDropdown.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(semesterLabelValues));
		
		boolean found = false;
		
		// 3. Loop through options and click matching text

		for(WebElement semesterLabel : semesterLabelValues )
		{
			if(semesterLabel.getText().trim().equalsIgnoreCase(semesterLabels.trim()))
			
			((JavascriptExecutor) driver ).executeScript("arguments[0].click();",semesterLabel );
			
			found = true;
			
			break;
		}
				
		if(!found)
		{
			throw new RuntimeException(" semester label value is not found: " + semesterLabels );
		}
		
		}
	
	


	public void select_section(String sections)
	{
		wait.until(ExpectedConditions.visibilityOf(sectionDropdown));
		sectionDropdown.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(sectionValues));
		
		boolean found = false;
		
		// Loop
		
		for(WebElement sectionvalue : sectionValues)
		{
			if(sectionvalue.getText().trim().equalsIgnoreCase(sections.trim()))
			
			((JavascriptExecutor) driver ).executeScript("arguments[0].click();",sectionvalue );
			
            found = true;
			
			break;
		}
		
		if(!found)
		{
			throw new RuntimeException("section value not found: " + sections );
		}

		
		
	}

	public void select_subject(String subjects)
	{
		wait.until(ExpectedConditions.visibilityOf(subjectdropdown));
		subjectdropdown.click();

		
		wait.until(ExpectedConditions.visibilityOfAllElements(subjectValues));
		
		boolean found = false;
		
		// Loop
		
		for(WebElement subjectvalue : subjectValues )
		{
			if(subjectvalue.getText().trim().equalsIgnoreCase(subjects.trim()))
			
			((JavascriptExecutor) driver ).executeScript("arguments[0].click();", subjectvalue );
			
			found = true;
			
			break;
		}

		if(!found)
		{
			throw new RuntimeException("Subjects value not found: " + subjects );
		}
		
	}

	public void select_attenadnce_date(String AttendanceDates)
	{
		wait.until(ExpectedConditions.visibilityOf(attendanceDatefield));
		attendanceDatefield.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(attendancevalues));
		
		boolean found = false;
		
		// Loop
		
		for(WebElement AttendanceDate : attendancevalues )
			
		{
			if(AttendanceDate.getText().trim().equalsIgnoreCase(AttendanceDates.trim()))
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", AttendanceDate );
			
			found= true;
			
			break;
		}
		
		if(!found)
		{
			throw new RuntimeException("attendance value is not found : " + AttendanceDates );
		}
	}

	public void select_lecture_slots(String lectureSlots)
	{

		wait.until(ExpectedConditions.visibilityOf(lectureslotDropdown));
		lectureslotDropdown.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(lectureslotValues));

		boolean found = false;
		
		// Loop
		
		for (WebElement lectureSlot : lectureslotValues)
		{
			if(lectureSlot.getText().trim().equalsIgnoreCase(lectureSlots.trim()))
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lectureSlot );
			
			found = true;
			
			break;
		}
		
		if(!found)
		{
			throw new RuntimeException(" slots not found: " + lectureSlots );
		}
		
		
	}

	public void select_Unit(String units)
	{
		wait.until(ExpectedConditions.visibilityOf(unitDropdown));
		unitDropdown.click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(unitValues));
		
		boolean found = false;
		
		// Loop
		
		for(WebElement unit : unitValues)
		{
			
			if(unit.getText().trim().equalsIgnoreCase(units.trim()))
		
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();",unit );
		
		    found = true;
		
		   break;
		}
		
		if(!found)
		{
			throw new RuntimeException(" Units are not found " + units);
		}
		
	}

	public void select_topic(String topics)
	{
		wait.until(ExpectedConditions.visibilityOf(topicDropdown));
		topicDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(topicValues));

		boolean found = false;
		
		// Loop
		
		for(WebElement topic : topicValues )
		{
			if(topic.getText().trim().equalsIgnoreCase(topics.trim()))
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", topic );
			
			found = true;
			
			break;
		}
		
		if(!found)
		{
			throw new RuntimeException(" Topic not found : " + topics );
		}
		
		
	}

	public void select_topic_overview(String topicOverviewStatues)
	{
		wait.until(ExpectedConditions.visibilityOf(TopicOverviewfield));
		TopicOverviewfield.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(topicOverviewStatus));
		
		boolean found = false;
		
		// Loop
		
		for(WebElement topicOverview : topicOverviewStatus)
			
		{
			if(topicOverview.getText().trim().equalsIgnoreCase(topicOverviewStatues.trim()))
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", topicOverview);
			
			found = true;
			
			break;
			
		}
		
		if(!found)
		{
			throw new RuntimeException(" Topic overview status value is not found : " + topicOverviewStatues );
		}

		
		
	}
}










































