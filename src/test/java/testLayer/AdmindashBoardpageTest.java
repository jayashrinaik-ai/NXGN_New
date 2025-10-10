package testLayer;

import org.testng.annotations.Test;

import pageLayer.AdminDashboardpage;
import pageLayer.Loginpage;
import testBase.BaseClass;

public class AdmindashBoardpageTest extends BaseClass {
	
	@Test
	
	public void Verify_Student_InfoTab_Module()
	{
		// first we will login
		
		Loginpage login = new Loginpage(driver);
		
		login.enter_email_In_Emailfield(property.getProperty("email"));
		
		login.enter_password_In_PasswordField(property.getProperty("password"));
		
		login.click_On_LoginButton();
		
		// we craete Admin dashboard page object
		
		AdminDashboardpage admindashboard = new AdminDashboardpage(driver);
		
		admindashboard.click_On_Student_Info_Module();
		
		
		admindashboard.click_On_Subjectwise_Attendance_Submodule_In_New_Tab();
		
		
	}
	
	

}
