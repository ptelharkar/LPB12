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
import com.training.pom.ChangeOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeOrder 
{
	private WebDriver driver;
	private String baseUrl;
	private ChangeOrderPOM changeOrderPOM;
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
		changeOrderPOM = new ChangeOrderPOM(driver);
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
	public void changeOrderTest() throws InterruptedException 
	{
		changeOrderPOM.sendUserName("admin");
		changeOrderPOM.sendPassword("admin@123");
		changeOrderPOM.clickLoginBtn();
		Thread.sleep(2000);
		changeOrderPOM.mouseOverSalesMenu();
		changeOrderPOM.clickOrdersMenu();
		Thread.sleep(2000);
		changeOrderPOM.selectRow("315");
		changeOrderPOM.clickEditBtn();
		Thread.sleep(2000);
		changeOrderPOM.clickCustContinueBtn();
		Thread.sleep(2000);
		changeOrderPOM.clickRemoveProductBtn();
		changeOrderPOM.sendProductName("Lorem ipsum dolor sit amet");
		Thread.sleep(2000);
		changeOrderPOM.sendQuantity("1");
		changeOrderPOM.clickproductAddBtn();
		Thread.sleep(5000);
		changeOrderPOM.clickCartBtn();
		Thread.sleep(2000);
		changeOrderPOM.clickPaymentContBtn();
		Thread.sleep(2000);
		changeOrderPOM.clickshipAddressBtn();
		Thread.sleep(2000);
		changeOrderPOM.shippingMethod("Free Shipping - Rs.0");
		changeOrderPOM.clickSaveBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot("screenshots/ChangeOrder");
   }

}
