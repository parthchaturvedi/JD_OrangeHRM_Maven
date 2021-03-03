package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import java.sql.DriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Handling_Diffrent_Objects {
	ChromeDriver driver;
  @Test(priority = 1)
  public void RadioButton() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElementById("male").click();
  }

	
  @Test(priority = 2) public void CheckBox() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElementByXPath("//input[@value='Automation']").click();
	  
  }

  @Test(priority = 3) public void DropDown() throws InterruptedException {
	  Thread.sleep(3000);
	  Select userrole= new Select(driver.findElementById("testingDropdown"));
	  userrole.selectByVisibleText("Automation Testing");
 
  }
  @Test(priority=4)
  public void DoubleClick() throws InterruptedException {
	  Thread.sleep(5000);
	  Actions act=new Actions(driver);
	  WebElement Click=driver.findElementById("dblClkBtn");
	  act.doubleClick(Click).build().perform();
	  driver.switchTo().alert().accept();
  }
	  @Test(priority = 5) public void AlertBox() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.findElementByXPath("//button[normalize-space()='Generate Alert Box']").click();
		  driver.switchTo().alert().accept();
	  
	  }
	  
	  @Test(priority = 6) public void ConfirmBox() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.findElementByXPath("//button[normalize-space()='Generate Confirm Box']").click();
		  driver.switchTo().alert().dismiss();
		  Thread.sleep(5000);
	  
	  }
	  @Test(priority = 7)
	  public void DragDrop() throws InterruptedException {
		  Actions act=new Actions(driver);
		  WebElement Drag=driver.findElementById("sourceImage");
		  WebElement Drop=driver.findElementById("targetDiv");
		  act.dragAndDrop(Drop,Drag).build().perform();
		  Thread.sleep(5000);
	  }
	 
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  Thread.sleep(8000);
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
