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
import com.training.pom.FilterOrderDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrderDetails 
{
	private WebDriver driver;
	private String baseUrl;
	private FilterOrderDetailsPOM filterOrderDetails;
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
		filterOrderDetails = new FilterOrderDetailsPOM(driver); 
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
	public void filerOrder() throws InterruptedException
	{
		filterOrderDetails.sendUserName("admin");
		filterOrderDetails.sendPassword("admin@123");
		Thread.sleep(5000);
		filterOrderDetails.clickLoginBtn();
		filterOrderDetails.mouseOverSalesMenu();
		filterOrderDetails.clickOrdersMenu();
		filterOrderDetails.sendOrderId("76");
		filterOrderDetails.clickFilterBtn();
		filterOrderDetails.selectOrderStatus("Pending");
		filterOrderDetails.clickFilterBtn();
		filterOrderDetails.clickDateAddedBtn();
		filterOrderDetails.selectAddedDate("11","Dec", "2018");
		filterOrderDetails.clickFilterBtn();
		filterOrderDetails.sendCustomerName("manzoor");
		filterOrderDetails.clickFilterBtn();
		filterOrderDetails.sendTotal("5");
		filterOrderDetails.clickFilterBtn();
		filterOrderDetails.clickDateModifiedBtn();
		filterOrderDetails.selectModDate("11","Dec","2018");
		Thread.sleep(2000);
		filterOrderDetails.clickFilterBtn();
		screenShot.captureScreenShot("screenshots/FilterOrderDetails");
		
	}
}
