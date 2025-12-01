package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.Status;

import lombok.experimental.Helper;
import testBase.BaseClass;

public class LogHelper {
	
	public static final Logger logger = LogManager.getLogger(Helper.class);

	// Common method to log to both Extent Report and Log4j
	
	public static void info(String message)
	{
		logger.info(message);
		
		if(BaseClass.extentTest.get() != null)
		{
			BaseClass.extentTest.get().log(Status.INFO, message);
		}
	}
	
	
	public static void pass(String message)
	{
		logger.info(" ✅ " + message);
		
		if(BaseClass.extentTest.get()!=null)
		{
			BaseClass.extentTest.get().log(Status.PASS, message);
		}
	}
	
	public static void fail(String message)
	{
		logger.info(" ❌ " + message);
		
		if(BaseClass.extentTest.get()!=null)
		{
			BaseClass.extentTest.get().log(Status.FAIL, message);
		}
	}
	
	public static void warn(String message)
	{
		logger.info(" ⚠️ " + message);
		
		if(BaseClass.extentTest.get()!=null)
		{
			BaseClass.extentTest.get().log(Status.WARNING, message);
		}
	}
}
