package com.letskodeit.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Letskodeit.qa.pages.LoginPage;
import com.Letskodeit.qa.pages.PracticePage;

import base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	PracticePage practicepage;
	
	
	public LoginPageTest() {
		//The purpose of creating this constructor to call the testbase class constructor
		super();
	
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		initialisation();
		loginpage= new LoginPage();
	}
	
	@Test()
	public void clickonpopuplink() throws InterruptedException {
		loginpage.closepopup();
		loginpage.Clickonsignupbutton();
		loginpage.ClickonLoginbutton();
		Thread.sleep(2000);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String Title=loginpage.validateTitle();
		Assert.assertEquals(Title, "Let's Kode It | Selenium Webdriver Tutorial | Rest API Tutorial");
		practicepage=loginpage.clickonpracticepage();
		
		
	}
	
	
	
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
