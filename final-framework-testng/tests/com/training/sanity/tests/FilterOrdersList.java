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
import com.training.pom.FilterOrdersListPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrdersList {
	private WebDriver driver;
	private String baseUrl;
	private FilterOrdersListPOM filterOrdersList;
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
		filterOrdersList = new FilterOrdersListPOM(driver); 
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
		filterOrdersList.sendUserName("admin");
		filterOrdersList.sendPassword("admin@123");
		filterOrdersList.clickLoginBtn();
		filterOrdersList.mouseOverSalesMenu();
		filterOrdersList.clickOrdersMenu();
		filterOrdersList.sendOrderId("315");
		filterOrdersList.clickFilterBtn();
		filterOrdersList.sendCustomerName("Laxmi");
		filterOrdersList.clickFilterBtn();
		screenShot.captureScreenShot("screenshots/FilterOrder");
	}
}
