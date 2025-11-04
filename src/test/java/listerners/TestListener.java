package listerners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testBase.BaseClass;

//import utils.ExtentManager;
//import utils.ScreenshotUtil;

public class TestListener extends BaseClass implements ITestListener {
	
	private static ExtentReports extent = utils.ExtentManager.getInstance();
	
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override

	public void onTestFailure( ITestResult result)

	{
		test.get().log(Status.FAIL, "Test Failed" + result.getThrowable());
		
		//utils.takeScreenshot(driver, result.getName());
		
		
		
		try {
			// Use driver from BaseTest (inherited)
			// Get driver from the test instance (this ensures the right driver object)

			WebDriver driver = ((BaseClass) result.getInstance()).getDriver();
			
			String screenshotpath= utils.ScreenshotUtil.takeScreenshot(driver, result.getName());
			
			// Take screenshot safely
			
			if(screenshotpath!= null && screenshotpath.toLowerCase().contains("no screenshot"))
			{
				test.get().addScreenCaptureFromPath(screenshotpath);
				
				System.out.println("<a href ='" +screenshotpath + "' target='_blank'>Screenshot</a>");

				Reporter.log("<br><a href='" + screenshotpath + "' target='_blank'>" + "<img src='" + screenshotpath + "' height='200' width='300'/></a><br>");
				
			}
			
				
			else {
				
				System.out.println("screenshot path invalid" + result.getName());
			}

			
			
			
//			
//			System.out.println(" Test failed: " + result.getName());
//
//			System.out.println("Screenshot captured: " + screenshotpath);
//
//			// Attach screenshot to TestNG report
//			System.setProperty("org.uncommons.reportng.escape-output", "false");

			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



	@Override

	public void onTestSkipped(ITestResult result ) {

		try
		{
			WebDriver driver = ((BaseClass) result.getInstance()).getDriver();
		
			
			utils.ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, "Test Passes");
		// Optional: Capture screenshot for passed tests too

	}

	@Override 
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		
		test.set(extentTest);
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println(" Test suite started " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush(); // 🔑 very important - writes the report file
		
		System.out.println(" Extent report generated successufully ");
	}
}
