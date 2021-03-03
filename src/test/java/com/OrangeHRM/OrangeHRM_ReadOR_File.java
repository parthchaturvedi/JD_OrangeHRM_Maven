package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_ReadOR_File {
	@Test
	public static void Flight_Login() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//----Reading Object Repository File
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\Resources\\ObjectRepository.properties");
		Properties prop = new Properties();
		FileInputStream fileInput = new FileInputStream(file);
		prop.load(fileInput);
		//------------------------------------------
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id(prop.getProperty("iUserName"))).sendKeys("Admin");
		driver.findElement(By.id(prop.getProperty("iUserPass"))).sendKeys("admin123");
		driver.findElement(By.id(prop.getProperty("bLogin"))).click();
		driver.quit();
	}
}