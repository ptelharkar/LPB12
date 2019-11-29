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
import com.training.pom.ModifyOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ModifyOrder {
	private WebDriver driver;
	private String baseUrl;
	private ModifyOrderPOM modifyOrderPOM;
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
		modifyOrderPOM = new ModifyOrderPOM(driver);
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
		modifyOrderPOM.sendUserName("admin");
		modifyOrderPOM.sendPassword("admin@123");
		modifyOrderPOM.clickLoginBtn();
		Thread.sleep(2000);
		modifyOrderPOM.mouseOverSalesMenu();
		modifyOrderPOM.clickOrdersMenu();
		Thread.sleep(2000);
		modifyOrderPOM.selectRow("315");
		modifyOrderPOM.clickEditBtn();
		Thread.sleep(2000);
		modifyOrderPOM.clickCustContinueBtn();
		Thread.sleep(2000);
		modifyOrderPOM.clickRemoveProductBtn();
		modifyOrderPOM.sendProductName("Lorem ipsum dolor sit amet");
		Thread.sleep(2000);
		modifyOrderPOM.sendQuantity("1");
		modifyOrderPOM.clickproductAddBtn();
		Thread.sleep(5000);
		modifyOrderPOM.clickCartBtn();
		Thread.sleep(2000);
		modifyOrderPOM.clickPaymentContBtn();
		Thread.sleep(2000);
		modifyOrderPOM.clickshipAddressBtn();
		Thread.sleep(2000);
		modifyOrderPOM.shippingMethod("Free Shipping - Rs.0");
		modifyOrderPOM.clickSaveBtn();
		Thread.sleep(2000);
		modifyOrderPOM.checkProductSuccessMsg("Success: You have modified orders!");
    	Thread.sleep(3000);
		screenShot.captureScreenShot("screenshots/ModifyOrder");
		modifyOrderPOM.retrieveProdDetails();
		
   }

}


