package com.LarnautomationTestcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.LearnautomationPages.BaseClass;
import com.LearnautomationPages.LoginPage;

public class LoginTestCRM extends BaseClass{

 

	@Test

	public void loginApp() {
		
		logger=report.createTest("Login To CRM");
		
		//ExcelDataProvider excel =new ExcelDataProvider();

		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");

		//loginpage.loginToCRM("fira_701@hotmail.com", "Fira6640325");
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		
		logger.pass("Login Success");
		
		//Helper.captureScreenshot(driver);

	}

}
