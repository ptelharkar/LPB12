package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateCategory 
{
	private WebDriver driver;
	private String baseUrl;
	private CreateCategoryPOM createCategory;
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
		createCategory = new CreateCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test
	public void filerOrder() throws InterruptedException
	{
		createCategory.sendUserName("admin");
		createCategory.sendPassword("admin@123");
		Thread.sleep(5000);
		createCategory.clickLoginBtn();
		createCategory.mouseOverCatelogMenu();
		Thread.sleep(2000);
		createCategory.clickCategoriesMenu();
		Thread.sleep(2000);
		createCategory.clickAddNewBtn();
		Thread.sleep(2000);
		createCategory.sendCatName("ORNAMENTS");
		createCategory.sendCatDesc("ornaments for ladies");
		createCategory.sendMetaTagTitle("ORNAMENTS");
		createCategory.sendMetaTagDesc("ornaments for ladies");
		createCategory.clickSaveBtn();
		Thread.sleep(2000);
		createCategory.checkSuccessMsg("Success: You have modified categories!");
		screenShot.captureScreenShot("screenshots/CategoryAddSuccess");
		Thread.sleep(2000);
		Reporter.log("Can't see product icon on Category page in order to executed the step 10 of RTTC_048 test case where I need to click on product icon");
		createCategory.clickProductsMenu();
		createCategory.clickAddNewBtn();
		createCategory.sendProductName("Finger Ring");
		createCategory.sendMetaTagTitle("Finger Ring for ladies");
		createCategory.clickDataTab();
		createCategory.sendModel("SKU-95");
		createCategory.clickLinkTab();
		createCategory.selectCategory("ORNAMENTS");
		Thread.sleep(2000);
		createCategory.clickSaveBtn();
		createCategory.checkProductSuccessMsg("Success: You have modified products!");
		screenShot.captureScreenShot("screenshots/ProductModSuccess");
	}
}
