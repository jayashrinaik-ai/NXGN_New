package testLayer;

import org.testng.annotations.Test;

import pageLayer.AddStudentSubjectwiseAttendancePage;
import pageLayer.AdminDashboardpage;
import pageLayer.Loginpage;
import pageLayer.StudentAttendanceListpage;
import testBase.BaseClass;

public class AddStudentSubjectwiseAttendancePageTest extends BaseClass {
	
	
	
	@Test(priority = 1)
	
	public void verify_login()
	{
		// To mark the attendance first we will login the website
		
		Loginpage loginpage = new Loginpage(driver);
		
		loginpage.enter_email_In_Emailfield(property.getProperty("email"));
		
		loginpage.enter_password_In_PasswordField(property.getProperty("password"));
		
		loginpage.click_On_LoginButton();
		
	}
		
	@Test(priority = 2,dependsOnMethods = {"verify_login"})
	
	public void verify_subjectwise_Attendance_module_from_sidebar()
	
		{
		// click on subjectwise attendance module on sidebar manager in admindashboard page 
		
		AdminDashboardpage adminDashboardpage = new AdminDashboardpage(driver);
		
		adminDashboardpage.click_On_Student_Info_Module();
		
		adminDashboardpage.click_On_Subjectwise_Attendance_Submodule_In_New_Tab();
		
		}
	
	@Test(priority = 3)
	
	public void verify_add_Attendance_CTA()
	{
		
		// page will open new window and we will click on CTA i.e Add attendance
		
		StudentAttendanceListpage studentAttendanceListpage = new StudentAttendanceListpage(driver);
		
		studentAttendanceListpage.click_On_Add_Attendance_CTA();
	}
	
	
//	@Test(priority = 4, dependsOnMethods = {"verify_login"})
	
	@Test(priority = 4)
	
	public void Verify_Add_Attendance_Module()
	{
		
	//	driver.get("https://stg-dbit.nxgnconnect.com/subjectwise-attendance/create");
		// Add attendance
		
		AddStudentSubjectwiseAttendancePage addStudentSubjectwiseAttendancePage = new AddStudentSubjectwiseAttendancePage(driver);
		
		
		addStudentSubjectwiseAttendancePage.select_subject_category_type("Department");
		
		addStudentSubjectwiseAttendancePage.select_branch("Don Bosco Panaji Goa");
		
		addStudentSubjectwiseAttendancePage.select_department("Eco DND");
		
		addStudentSubjectwiseAttendancePage.select_programe("DND program");
		
		addStudentSubjectwiseAttendancePage.select_semester("DND semester");
		
		addStudentSubjectwiseAttendancePage.select_semester_label("DND sem Leb");
		
		addStudentSubjectwiseAttendancePage.select_section("Dummy section");
		
		addStudentSubjectwiseAttendancePage.select_subject("DND subject practical");
		
		addStudentSubjectwiseAttendancePage.select_attenadnce_date("28");
		
		addStudentSubjectwiseAttendancePage.select_lecture_slots("7:40 PM To 8:00 PM");
		
	    addStudentSubjectwiseAttendancePage.select_Unit("Dummy Unit 1");
		
		addStudentSubjectwiseAttendancePage.select_topic("tp1");
		
		addStudentSubjectwiseAttendancePage.select_topic_overview("In Progress");
		
		
		
	}
	
	
	
}



































