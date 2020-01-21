package com.LearnautomationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {//div[@class='ui fluid large blue submit button']
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(name="email") WebElement uName;
	
	@FindBy(id="pass") WebElement pass;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[2]/td[3]/label[1]/input[1]") WebElement loginButtom;
	
	public void loginToCRM(String userNameApplication, String passwordApplication) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		uName.sendKeys(userNameApplication);
		pass.sendKeys(passwordApplication);
		loginButtom.click();
	}
	
	
	

}
