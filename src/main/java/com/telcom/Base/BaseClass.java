package com.telcom.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.util.TestUtil;
import com.util.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListener EventListener;
	
	public BaseClass() {
		
		try {
			
			prop = new Properties();
			
			FileInputStream input = new FileInputStream ("C:\\Users\\hchalla2020\\TestAutomation\\PageobjectModelFW\\src\\main\\java\\com\\telcom\\config\\config.properties");
			
			prop.load(input);
			
		}catch(Exception e) {

			e.printStackTrace();
		}
	}
	
	public static void inception() {
		
		String browsertype = prop.getProperty("browser");
		 
		if(browsertype.equals("chrome")) {
			
		      System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
				
			   driver = new ChromeDriver();

		    //driver.get("http://demo.guru99.com/V1/index.php");
		} else if(browsertype.equals("IE")) {
			
			 System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
				
			  driver = new ChromeDriver();
		}
		
		edriver = new EventFiringWebDriver(driver);
		EventListener = new WebEventListener();
		edriver.register(EventListener);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
