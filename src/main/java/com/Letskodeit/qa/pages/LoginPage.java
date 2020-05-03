package com.Letskodeit.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or OR 
	
	@FindBy(id="comp-jgmoxws4")
	WebElement closepop;
	
	
	@FindBy(id="comp-iiqg1vggactionTitle")
	WebElement signup;
	
	@FindBy(id="signUpDialogswitchDialogLink")
	WebElement login;
	
	
	@FindBy(id="memberLoginDialogemailInputinput")
	WebElement username;
	
	@FindBy(id="memberLoginDialogpasswordInputinput")
	WebElement password;
	
	@FindBy(id="memberLoginDialogokButton")
	WebElement loginButton;
	
	@FindBy(xpath="//li[@id='DrpDwnMn03']")
	WebElement practicepage;
	
	
	 
	@FindBy(xpath="//*[@id=\"block-1069048\"]/div/div/div/h1")
	WebElement PracticePageLabel;
	
	//This is to initialise the OR or page factory
	public LoginPage() {
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);
		//Pagefactory is the inbuilt method to initialise the  OR	
	}
	
	public void closepopup() throws InterruptedException {
		Thread.sleep(2000);
		closepop.click();
		Thread.sleep(2000);
		
	}
	
	public void Clickonsignupbutton() throws InterruptedException {
		signup.click();
		Thread.sleep(2000);
	}
	
	public void ClickonLoginbutton() {
		login.click();
		
	}
	
	public void login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		
	}
	
	public String validateTitle() {
	return driver.getTitle();
	}
	
    
	public  PracticePage clickonpracticepage() throws InterruptedException {
		Thread.sleep(2000);
		practicepage.click();
		Thread.sleep(2000);
		
		return new PracticePage();
	}
	

}
