package com.letskodeit.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Letskodeit.qa.pages.LoginPage;
import com.Letskodeit.qa.pages.PracticePage;
import com.Letskodeit.qa.pages.SignUpPage;

import base.TestBase;


//Short cut key to import all package is Control+Shift+o
public class PracticePageTest extends TestBase
{
	LoginPage loginpage;
	PracticePage practicepage;
	SignUpPage signuppage;
	
	
	
	public PracticePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void SetUp() throws InterruptedException {
		initialisation();
		loginpage= new LoginPage();
		practicepage=new PracticePage();
		loginpage.closepopup();
		Thread.sleep(2000);
		loginpage.Clickonsignupbutton();
		Thread.sleep(2000);
		loginpage.ClickonLoginbutton();
		Thread.sleep(2000);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		practicepage=loginpage.clickonpracticepage();
		
	}
	

	
	@Test()
	public void LetsKodeitTest() throws InterruptedException {
		String Practice=   practicepage.PracticePageLabelvalidation();
		Assert.assertEquals(Practice, "Practice Page","Practice Page Tite value not matched");//This second statement in assertion helps in reporting	
		practicepage.radiolist();
		Thread.sleep(2000);
		practicepage.checklist();
		Thread.sleep(2000);
		practicepage.dropdown();
		Thread.sleep(2000);
		practicepage.Multipleselect();
		Thread.sleep(2000);	
		practicepage.openwindow();
		Thread.sleep(3000);
		
	}
	
	

	
	@AfterMethod()
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}

}
