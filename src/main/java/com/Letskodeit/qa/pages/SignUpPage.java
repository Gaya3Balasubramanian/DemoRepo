package com.Letskodeit.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SignUpPage extends TestBase {
	//6.11
	/*What is Cache look up
	   Cache look up is the attribute only available in page object model design patter.
	   If we use this after @find by , that element information will be called one time from 
	   the browser . After that it will be called by cache look up .This will incease the speed of 
	   the frame work.
	   
	   The main drawback of cache look up is when the page got refreshed or element id or xpath got changed , in that case stale element 
	   exception will be triggered. We can cache look up , provided if we are sure that the element id or xpath details will
	   not get changed . In that case we can proceed with cache look up .
	   
	   
	    */
	
	
	@FindBy(xpath="//input[@id='user_name']")
	@CacheLookup
	WebElement Fullname;
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='user_password_confirmation']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@id='user_unsubscribe_from_marketing_emails']")
	WebElement Unsubscribe;
	
	@FindBy(xpath="//input[@id='user_agreed_to_terms']")
	WebElement privacy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement signUpbutton ;
	
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterfullname(String FullName) {
		Fullname.sendKeys(FullName);
		
	}
	
	
	public void enteremailaddress(String email) {
		EmailAddress.sendKeys(email);
		
	}
	
	
	public void enterpassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	
	public void confirmpassword(String confrmpwd) {
		confirmPassword.sendKeys(confrmpwd);
		
	}
	
	
	public void clickonsignupbutton() {
		Unsubscribe.click();
		privacy.click();
		signUpbutton.click();
		
		
	}
	

}
