package com.letskodeit.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Letskodeit.qa.pages.SignUpPage;

import base.TestBase;
import utilclass.TestUtil;

public class SignUpPageTest extends TestBase {
	SignUpPage signupPage;
	String SheetName = "TestData";

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod()
	public void SetUpMethod() throws InterruptedException {
		String url = "https://sso.teachable.com/secure/42299/users/sign_up?reset_purchase_session=1";
		initialisation();
		signupPage = new SignUpPage();
		Thread.sleep(3000);
		driver.navigate().to(url);

	}

	/*@DataProvider(name="TestData")
	public Object[][] GetTestData() {
		Object[][] data = TestUtil.getTestData(SheetName);
		return data;
	}*/
	
	//String FN, String EId, String PD, String CPD

	@Test
	public void clickonsignupbutton()
			throws InterruptedException {
		Thread.sleep(4000);
		signupPage.enterfullname(prop.getProperty("fullnme"));
		Thread.sleep(2000);
		signupPage.enteremailaddress(prop.getProperty("emailid"));
		Thread.sleep(2000);
		signupPage.enterpassword(prop.getProperty("password1"));
		Thread.sleep(2000);
		signupPage.confirmpassword(prop.getProperty("confirmpassword"));
		Thread.sleep(2000);
		signupPage.clickonsignupbutton();

	}

	@AfterMethod()
	public void tearDownMethod() {
		driver.quit();
	}

}
