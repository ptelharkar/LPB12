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
import com.training.pom.DeleteOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteOrder {
	private WebDriver driver;
	private String baseUrl;
	private DeleteOrderPOM deleteOrderPOM;
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
		deleteOrderPOM = new DeleteOrderPOM(driver); 
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
	public void deleteorderTest() throws InterruptedException 
	{
		deleteOrderPOM.sendUserName("admin");
		deleteOrderPOM.sendPassword("admin@123");
		deleteOrderPOM.clickLoginBtn();
		Thread.sleep(5000);
		deleteOrderPOM.mouseOverSalesMenu();
		deleteOrderPOM.clickOrdersMenu();
		Thread.sleep(2000);
		deleteOrderPOM.selectRow();
		deleteOrderPOM.clickDeleteBtn();
		deleteOrderPOM.clickOkBtn();
		screenShot.captureScreenShot("screenshots/DeleteOrder");
   }
	
}
