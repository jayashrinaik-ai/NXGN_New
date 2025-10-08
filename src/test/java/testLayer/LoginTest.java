package testLayer;

import org.testng.annotations.Test;

import pageLayer.Loginpage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void verify_Login_Functionlity()
	{
		//login page object get property from property file
		
		Loginpage login = new Loginpage(driver);
		
		login.enter_email_In_Emailfield(property.getProperty("email"));
		
		login.enter_password_In_PasswordField(property.getProperty("password"));
		
		login.click_On_LoginButton();
	}

}
