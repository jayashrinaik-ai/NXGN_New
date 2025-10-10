package testLayer;

import org.testng.annotations.Test;

import pageLayer.AdminDashboardpage;
import pageLayer.Loginpage;
import pageLayer.StudentAttendanceListpage;
import testBase.BaseClass;

public class AddStudentSubjectwiseAttendancePageTest extends BaseClass {
	
	
	@Test
	
	public void mark_Attendace_for_student()
	{
		// To mark the attendance first we will login the website
		
		Loginpage loginpage = new Loginpage(driver);
		
		loginpage.enter_email_In_Emailfield(property.getProperty("email"));
		
		loginpage.enter_password_In_PasswordField(property.getProperty("password"));
		
		loginpage.click_On_LoginButton();
		
		
		// click on subjectwise attendance module on sidebar manager in admindashboard page 
		
		AdminDashboardpage adminDashboardpage = new AdminDashboardpage(driver);
		
		adminDashboardpage.click_On_Student_Info_Module();
		
		adminDashboardpage.click_On_Subjectwise_Attendance_Submodule_In_New_Tab();
		
		// page will open new window and we will click on CTA i>e Add attendance
		
		StudentAttendanceListpage studentAttendanceListpage = new StudentAttendanceListpage(driver);
		
		studentAttendanceListpage.click_On_Add_Attendance_CTA();
		
	}

}
