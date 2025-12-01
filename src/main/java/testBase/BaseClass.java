package testBase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;


import utils.ExtentManager;

public class BaseClass {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static ExtentReports extent;
	
	public Properties property;

	@BeforeMethod(alwaysRun= true)
	
	@Parameters({"browser", "baseURL"})
	
	public void setUp(Method method, @Optional("chrome") String browserName,
	          @Optional("https://stg-dbit.nxgnconnect.com/login")String baseURL) throws IOException 
{
	
				// Initialize Extent Report only once

				if (extent == null) {
					extent = ExtentManager.getInstance();
				}
				
				// Create Extent test node for each test method

				ExtentTest test = extent.createTest(method.getName());

				extentTest.set(test);

				// load config.properties
		
				property= new Properties();
				
				FileReader file = new FileReader (System.getProperty("user.dir")+ "/src/test/resources/config.properties");

				property.load(file);
		
			
				// Browser setup using switch-case  // Launch browser
		
		switch (browserName.toLowerCase())
		{

		case "chrome": 

			WebDriverManager.chromedriver().setup();

			driver.set(new ChromeDriver());

			break;

		case "edge": 

			System.setProperty("webdriver.edge.driver", "C:\\Users\\vikas\\eclipse-workspace\\NXGN_New\\driver\\drivers\\msedgedriver.exe");

			driver.set(new EdgeDriver());

			break;


		case "firefox":

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			options.setBinary("C:\\Users\\vikas\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

			driver.set(new FirefoxDriver());
			
			break;
																	
																				//	case "opera":
																	
																				//	System.setProperty("webdriver.opera.driver", "C:\\Users\\vikas\\eclipse-workspace\\Practice\\Drivers\\drivers\\operadriver.exe");
																	
																	
																				//	OperaOptions operaOption = new OperaOptions();
																	
																				//			operaOption.setBinary("C:\\Users\\vikas\\AppData\\Local\\Programs\\Opera\\opera.exe");
																				//			
																				//			operaOption.addArguments("--no-sandbox");
																				//			
																				//			operaOption.addArguments("--disable-dev-shm-usage");
																				//			
																				//			operaOption.addArguments("--remote-debugging-port=9222");
																				//			
																				//			operaOption.addArguments("--disable-gpu");
																				//			
																				//			operaOption.addArguments("--disable-extensions");
																				//			
																				//			operaOption.addArguments("--start-maximized");
																				//			
																				//			driver = new OperaDriver(operaOption);
				


		default: 

			throw new IllegalArgumentException("Invalid browser name: " + browserName);

		}
		
		WebDriver localDriver = driver.get();
		
		localDriver.manage().window().maximize();

		localDriver.get(baseURL);

		localDriver.manage().deleteAllCookies();
		
		// Ensure screenshots folder exists at test start
		
		File folder = new File(System.getProperty("user.dir") + "/test-output/screenshots/");

		if (!folder.exists())
		{
			folder.mkdirs();
		}
		
		extentTest.get().log(Status.INFO, "Browser Launched: " + browserName);

		extentTest.get().log(Status.INFO, "Navigated to URL: " + baseURL );
	}


		@AfterMethod(alwaysRun= true)

		public void teardown() {
		
		WebDriver localDriver = driver.get();
		
		if(localDriver != null)
		{
			localDriver.quit();

			extentTest.get().log(Status.INFO, "Browser closed successfully.");
		}
		
		if(extent != null)
		{
			extent.flush();  // ✅ Generate/Update report after each test
		}
	}

	//	 Getter method

	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public ExtentTest getExtentTest()
	{
		return extentTest.get();
	}

}
