package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.crm.qa.util.TestUtil;

public class LoginTest {
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	//String configFileName ="C:\\Shiva\\JavaPractice\\Log4J\\GenerateLogs\\src\\main\\resources\\log4j.properties";
	
	@BeforeMethod
	public void setUp() {
		//PropertyConfigurator.configure(configFileName);
		
		System.setProperty("webdriver.chrome.driver","C:\\Shiva\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Launching");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		log.info("Application URL");
	}
	
	 @Test(priority=1)
	  public void freeCrmTitleTest() {
		  String title = driver.getTitle();
		  Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	  }
	  
	  @Test(priority=2)
	  public void freeCrmImageTest() {
		  boolean flag = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		  Assert.assertTrue(flag);
	  }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
