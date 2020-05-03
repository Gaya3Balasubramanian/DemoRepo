package com.Letskodeit.qa.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class PracticePage extends TestBase {

	
	@FindBy(xpath="//*[@id=\"block-1069048\"]/div/div/div/h1")
	WebElement PracticePageLabel;
	
	@FindBy(xpath="//input[@type='radio']")
	List<WebElement> radiolist;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> Checkboxlist;
	
	
	@FindBy(xpath="//select[@id='carselect']")
	WebElement DropDown;
	
	@FindBy(xpath="//select[@id='multiple-select-example']")
	WebElement Multiselect;
	
	@FindBy(id="openwindow")
	WebElement openwindow;
	
	
	public PracticePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String PracticePageLabelvalidation() {
		String practicepage=PracticePageLabel.getText();
		return practicepage;
		
	}
	
	public void radiolist() {
		int size=radiolist.size();
		System.out.println("RadioButton List size is:" + size );
		
		for(WebElement RadiobuttonList:radiolist) {
			RadiobuttonList.click();
			
		}
		
	}
	
	
	public void checklist() {
		int size1= Checkboxlist.size();
		System.out.println("Check box size is"+ size1);
		
		for(WebElement Checkbox:Checkboxlist) {
			Checkbox.click();
		}
	}
	
	
	
	public void dropdown() {
		Select sel= new Select((WebElement) DropDown);
		List<WebElement>dropdown= sel.getOptions();
		int size2= dropdown.size();
		System.out.println("Dropdown list size is"+size2);
		for(WebElement dropdownList:dropdown) {
			dropdownList.click();
			String dropdownlistname=dropdownList.getText();
			System.out.println(dropdownlistname);
			
		}
	}
	
	
	public void Multipleselect() {
		Select sel1= new Select((WebElement) Multiselect);
		List<WebElement> multi=sel1.getOptions();
		int size3=multi.size();
		System.out.println("Multi selection size is :" + size3);
		for(WebElement multiselectlist:multi) {
			multiselectlist.click();
			String Multiselect= multiselectlist.getText();
			System.out.println("Multiselect options are:" +Multiselect );
			
		}
	}
	
	public void openwindow() throws InterruptedException {
		/*step1
		1. Get current window handle which is parent handle using get window handle method 
		2. Then click the exact webelement
		3. Using collection Set<String> get all the window handles
		4. Use for loop to get the wholes window handles 
		5. Then in the for loop , using if condition , check like if not the parent handle use switch to method to get into exact 	
		*/
		String ParentHandle= driver.getWindowHandle();
	    System.out.println("Parent handle is :" + ParentHandle);
	    openwindow.click();
	    Thread.sleep(2000);
	    Set<String> handles=driver.getWindowHandles();
	    for(String handle:handles) {
	    	if(!ParentHandle.endsWith(handle)) {
	    		driver.switchTo().window(handle);
	    		Thread.sleep(2000);
	    		driver.close();
	    		
	    	}
	    }
	       
		
	}
	
	
	public SignUpPage cliconSignuppage() {
		driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_up?reset_purchase_session=1");
		return new SignUpPage();
	}
	
	
	
	
	

	
	
	
}
