package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Flipkart_TestNG {
	ChromeDriver driver;
	// WebDriver driver;

	@Test
	public void EnterCustomerID() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElementByXPath("/html[1]/body[1]/div[2]/div[1]/div[1]/button[1]").click();
		WebElement fashion = driver.findElementByXPath("//div[contains(text(),'Fashion')]");
		Actions action = new Actions(driver);
		action.moveToElement(fashion).build().perform();
		WebElement Men_top=driver.findElementByLinkText("Men's Top Wear");
		action.moveToElement(Men_top).build().perform();
		driver.findElementByLinkText("Men's T-Shirts").click();
		Thread.sleep(4000);
	}

	// Pre-Condition
	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// This will wait for Page to load
		// driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		// This will store or rememember the cookies or navigation in terms of
		// back and forward
		driver.navigate().to("https://www.flipkart.com/");
	}

	// Post Condition
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}


}
