package com.LearnautomationPages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.LearnautomationUtility.BrowserFactory;
import com.LearnautomationUtility.ConfigDataProvider;
import com.LearnautomationUtility.ExcelDataProvider;
import com.LearnautomationUtility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
		Reporter.log("Setting Done test can be Started", true);
		
	}
	
	  @BeforeClass
		public void setup() {
		  
			
			Reporter.log("Trying to start Browser and Getting application ready", true);
			
			driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
              
			Reporter.log("Browser and application is up and runing ", true);
		}
		
	  @AfterClass
		public void tearDown() {
			BrowserFactory.quitBrowser(driver);
	  }
	  
	  @AfterMethod
	  public void tearDownMethod(ITestResult result) throws IOException { 
		  
		  Reporter.log("Test is about to end ", true);
		  
		  if(result.getStatus()==ITestResult.FAILURE) {
		
			  logger.fail("Test faild", MediaEntityBuilder.createScreenCaptureFromPath("driver").build());
		  }
		  else if (result.getStatus()==ITestResult.SUCCESS)
		  {  
			  logger.fail("Test passed", MediaEntityBuilder.createScreenCaptureFromPath("driver").build());
		  }
		
	  
		  report.flush();
		  
		  Reporter.log("Test completed >>>>> Report Generated", true);
	  }
	  
	  

}
