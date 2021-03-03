package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Keys_Operation {
	ChromeDriver driver;
	  @Test(priority = 1)
	  public void Login() throws InterruptedException {
		  Thread.sleep(5000);
		  //Below is for using keys directly for entering the keys
			driver.findElementById("txtUsername").sendKeys("Admin",Keys.TAB,"admin123",Keys.ENTER);
			//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			//driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			//driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
		 
	  }
	  
	  @Test(priority = 2)
	  public void Logout() throws InterruptedException {
		  driver.findElementById("welcome").click();
		  Thread.sleep(2000);
		  driver.findElementByLinkText("Logout").click();
		  
				 
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
