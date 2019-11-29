package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterReturnListPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterReturnsList {
	private WebDriver driver;
	private String baseUrl;
	private FilterReturnListPOM filterReturnsList;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		filterReturnsList = new FilterReturnListPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void filterList() 
	{
		filterReturnsList.sendUserName("admin");
		filterReturnsList.sendPassword("admin@123");
		filterReturnsList.clickLoginBtn();
		filterReturnsList.mouseOverSalesMenu();
		filterReturnsList.clickReturnsMenu();
		filterReturnsList.sendRetunId("247");
		filterReturnsList.clickFilterBtn();
		filterReturnsList.sendCustomerName("reva");
		filterReturnsList.clickFilterBtn();
		screenShot.captureScreenShot("screenshots/FilterReturn");
	}
}
