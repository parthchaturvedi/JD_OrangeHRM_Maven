package com.OrangeHRM;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void Login_Successful_Scenario() throws InterruptedException {
		
		//Launch the chrome browser
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElementById("txtUsername").sendKeys("Admin");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("DashBoard")).isDisplayed();
		//driver.close();//close the current browser
		driver.quit();//close all the browser opened by Selenium
		
	}

}
