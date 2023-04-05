package com.telcom.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telcom.Base.BaseClass;
import com.telcom.Pages.AddcustomerPage;

public class AddcustomerPageTest extends BaseClass {
	
	AddcustomerPage AddCustPage;
	
	public AddcustomerPageTest() {
		
		super();//Test
		
	}
	
	@BeforeMethod
	public void StartUp() {
		
		inception();
		
		AddCustPage = new AddcustomerPage();
		
		
	}
	
	@Test()
	public void addcustomerdata2021() {
		
		AddCustPage = AddCustPage.addcustomerdata(prop.getProperty("fn"), prop.getProperty("ln"));
	
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.close();
	}
}
