package com.OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRM_TestData {
	
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"kumar", "admin123" },
				{"dixit", "admin123" }
				};

		}
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { 
				{ "admin", "", "Password cannot be empty"},
				{ "", "admin123", "Username cannot be empty" }, 
				{ "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, 
				{ "admin", "admin123", "Dashboard" } };

	}
	
	//-------------------------------------------- This is to read Excel Data------------
	
	@DataProvider(name = "LoginExcelData")
	public Object[][] Authentication() throws Exception{
		ReadExcel excel = new ReadExcel();
		String RelativePath = System.getProperty("user.dir");
		//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xlsx","SignIn");
		Object[][] testObjArray = excel.getExcelData(RelativePath+"\\OrangeHRM_TestData.xlsx","SignIn");
		System.out.println(testObjArray);
		return testObjArray;

	}
	
	

 }
