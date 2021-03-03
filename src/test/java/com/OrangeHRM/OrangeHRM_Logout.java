package com.OrangeHRM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Logout {
	EdgeDriver driver;
	//FirefoxDriver driver;
	@Before
	public void LaunchBrowser()
	{
		//Launch the chrome browser
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				//WebDriverManager.firefoxdriver().setup();
				//driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	@After
	public void CloseBrowser() {
		//driver.close();//close the current browser
		driver.quit();//close all the browser opened by Selenium
	}
	@Test
	public void Login_Successful_Scenario() throws InterruptedException {
		
		
		Thread.sleep(5000);
		driver.findElementById("txtUsername").sendKeys("dixit5");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		//Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("DashBoard")).isDisplayed();
		
		
	}

}
