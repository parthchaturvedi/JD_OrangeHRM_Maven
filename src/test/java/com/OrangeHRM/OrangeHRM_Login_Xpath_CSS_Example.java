package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Xpath_CSS_Example {
	ChromeDriver driver;
  @Test(priority = 1)
  public void Login() throws InterruptedException {
	  Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		//driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	 
  }
  
  @Test(priority = 2)
  public void Logout() throws InterruptedException {
	  //referring to Welcome Paul
	  driver.findElement(By.partialLinkText("Welcome")).click();
	  //driver.findElementById("welcome").click();
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
