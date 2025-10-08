package pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage  {
	
	private WebDriver driver;
	
	//constructor
	public Loginpage(WebDriver driver) {
		
		 this.driver = driver;
		 
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath ="/html/body/section/div/div[1]/div/div/div[3]/form/div[1]/div/input")
	
	private WebElement emailField;
	
	@FindBy (xpath ="//*[@id=\"passwordInput\"]")
	
	private WebElement passwordField;
	
	@FindBy ( xpath= "/html/body/section/div/div[1]/div/div/div[3]/form/div[4]/input")
	
	private WebElement loginButton;
	
	
	public void enter_email_In_Emailfield(String email) 
	{
		
		emailField.sendKeys(email);
		
	}
	
	public void enter_password_In_PasswordField(String password) 
	{
		
		passwordField.sendKeys(password);
		
		
	}
	
	public void click_On_LoginButton()
	{
		loginButton.click();
	}

}
