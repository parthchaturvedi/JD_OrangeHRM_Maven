package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Headless_Browser {
	WebDriverWait wait;//defined as global for explicit wait
	ChromeDriver driver;
  @Test(priority = 1)
  public void Login() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
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
	 // Thread.sleep(2000);
	  //--------explicit wait--------
			wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
			String ActText=element.getText();
			System.out.println(ActText);
			element.click();
	  //driver.findElementByLinkText("Logout").click();
	  
			 
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options= new ChromeOptions();
	  options.setHeadless(false);
	  options.addArguments("incognito");
	  driver= new ChromeDriver(options);
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
  }

  @AfterTest
  public void afterTest() {
	//driver.close();//close the current browser
			driver.quit();//close all the browser opened by Selenium
  }

}
