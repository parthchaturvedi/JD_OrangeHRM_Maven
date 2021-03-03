package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Navigation_Command {
	ChromeDriver driver;
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(5000);
		driver.findElementById("txtUsername").sendKeys("Admin");
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element=driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
	//---actions to hover and select ------------------
		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

        Actions action = new Actions(driver);
        
        action.moveToElement(admin).build().perform();
        WebElement usermanagement = driver.findElementByLinkText("User Management");
        action.moveToElement(usermanagement).build().perform();
        Thread.sleep(5000);
        driver.findElementByLinkText("Users").click();
        driver.navigate().back();
        Thread.sleep(3000);
        String DashboardUrl=driver.getCurrentUrl();
        System.out.println(DashboardUrl);
        driver.navigate().forward();
        Thread.sleep(3000);
        String UserUrl=driver.getCurrentUrl();
        System.out.println(UserUrl);
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
