package com.telcom.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telcom.Base.BaseClass;

public class AddcustomerPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"fname\"]")
	WebElement fname;
	
	@FindBy(xpath="//*[@id=\"lname\"]")
	WebElement lname;
	
	public AddcustomerPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	  public  AddcustomerPage addcustomerdata(String firstname, String lastname) {
	  
	  fname.sendKeys(firstname);
	  lname.sendKeys(lastname);
	  
	  return new AddcustomerPage();
	  
	  }
	 
}
