package testBase;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {

	public WebDriver driver;

	public Properties property;

	//	ChromeOptions options ;

	@BeforeClass
	public void setUp() throws IOException 
	{

		//options = new ChromeOptions();

		//options.addArguments("--headless");

		try {
			// load config.properties

			FileReader file = new FileReader (System.getProperty("user.dir")+ "/src/test/resources/config.properties");

			property= new Properties();

			property.load(file);

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		String browser = ConfigReader.getProperty("browser");


		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.get(property.getProperty("url"));

		driver.manage().deleteAllCookies();



	}
	
	public void createScreenshotFolder()

	{

		// Ensure screenshots folder exists at test start
		{
			File folder = new File(System.getProperty("user.dir") + "/test-output/screenshots/");

			if (!folder.exists())
			{
				folder.mkdirs();
			}
		}

	}

	

	@AfterClass
	public void teardown() {

		if(driver!=null)
		{
			driver.quit();
			
			System.out.println(" Browser closed successfully");
		}
	}

	//	 Getter method
	
	public WebDriver getDriver() {
		return driver;
	}

}
