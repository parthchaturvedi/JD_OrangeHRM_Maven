package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_GetText_GetTitle_GetCurrentURL {
	ChromeDriver driver;
  @Test(priority = 1)
  public void Login() throws InterruptedException {
	  Thread.sleep(5000);
		driver.findElementById("txtUsername").sendKeys("Admin");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	 
  }
  
  @Test(priority = 2)
  public void Logout() throws InterruptedException {
	  driver.findElementById("welcome").click();
	  Thread.sleep(2000);
	  driver.findElementByLinkText("Logout").click();
	  String ActText= driver.findElementById("logInPanelHeading").getText();
	  String ExpText="LOGIN Panel";
	  Assert.assertEquals(ExpText, ActText);
	  //To get the currentURL and Verify
	  String ActUrl=driver.getCurrentUrl();
	  String ExpUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	  Assert.assertEquals(ExpUrl, ActUrl);
	  //To verify title
	  String ActTitle=driver.getTitle();
	  String ExpTitle="OrangeHRM";
	  Assert.assertEquals(ExpTitle,ActTitle);
	  
			 
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
	//driver.close();//close the current browser
			driver.quit();//close all the browser opened by Selenium
  }

}
