package testLayer;

import org.testng.annotations.Test;

import pageLayer.AdminDashboardpage;
import pageLayer.Loginpage;
import pageLayer.StudentAttendanceListpage;
import testBase.BaseClass;

public class StudentAttendanceListPageTest extends BaseClass {

	
	@Test
	
	public void Verify_the_Add_Attendance_CTA()
	{
		Loginpage loginpage = new Loginpage(driver);
		
		
		loginpage.enter_email_In_Emailfield(property.getProperty("email"));
		
		loginpage.enter_password_In_PasswordField(property.getProperty("password"));
		
		loginpage.click_On_LoginButton();
		
		AdminDashboardpage adminDashboardpage = new AdminDashboardpage(driver);
		
		adminDashboardpage.click_On_Student_Info_Module();
		
		adminDashboardpage.click_On_Subjectwise_Attendance_Submodule_In_New_Tab();
		
		StudentAttendanceListpage studentAttendanceListpage = new StudentAttendanceListpage(driver);
		
		studentAttendanceListpage.click_On_Add_Attendance_CTA();
		
		
	}
}
