package testLayer;

import org.testng.annotations.Test;

import pageLayer.AdminDashboardpage;
import pageLayer.Loginpage;
import pageLayer.Study_material_Upload_content_Listpage;
import testBase.BaseClass;

public class Study_material_Upload_content_pageTest extends BaseClass {
	
	@Test(priority=1)
	
	public void upload_content()
	{
		Loginpage loginpage = new Loginpage(driver);
		
		loginpage.enter_email_In_Emailfield(property.getProperty("email"));
		
		loginpage.enter_password_In_PasswordField(property.getProperty("password"));
		
		loginpage.click_On_LoginButton();
		
		
	}
	
	@Test(priority=2,dependsOnMethods = {"upload_content"})
	
	public void clickOnUploadContent()
	{
		AdminDashboardpage adminDashboardpage = new AdminDashboardpage(driver);
		
		adminDashboardpage.click_On_Study_Material();
		
		adminDashboardpage.click_On_UploadContent_module();
	}
	

	@Test(priority=3)
	
	public void clickOnUploadContentCTA()
	{
		Study_material_Upload_content_Listpage study_material_Upload_content_Listpage = new Study_material_Upload_content_Listpage(driver);
		
		study_material_Upload_content_Listpage.click_On_upload_Content_CTA();
	}
	
	
}























