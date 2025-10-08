package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties property;
	
	 // Load properties file

	public static void initproperties() {
		
		if(property == null) {
			
			property = new Properties();
			
			try{
				
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
				
				property.load(fis);
				
				
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}

	
	// Get propert by key
	
	public static String getProperty(String key)
	{
		
		if(property == null)
		{
			initproperties();
		}
		
		return property.getProperty(key);
	}
}






